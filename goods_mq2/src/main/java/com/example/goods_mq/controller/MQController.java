package com.example.goods_mq.controller;

import com.alibaba.fastjson.JSON;
import com.example.goods_mq.model.dto.GoodMessage;
import com.example.goods_mq.model.entity.Good;
import com.example.goods_mq.service.GoodService;
import com.example.goods_mq.util.ActiveMQUtil;
import com.example.goods_mq.util.RedisUtil;
import com.example.goods_mq.util.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: goods_mq
 * @Package com.example.goods_mq.controller
 * @Description:
 * @date 2020/3/12 星期四 20:26
 */
@Controller
public class MQController {
    @Resource
    private GoodService goodService;
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private ActiveMQUtil mqUtil;
    @Autowired
    private WebSocket webSocket;
    //商品信息存在redis中key的前缀
    public static final String goodPrefix="goodInfo:";
    //库存在redis中key的前缀
    public static final String goodStock="goodStock:";
    //锁，购买之前在判断该商品当前是否有人在操作（商品主键前缀）
    public static final String lock="lock:";
    //购买状态(用户主键前缀)
    public static final String getStatus="got:";
    //成功
    public static final String getSuccess="success";
    //失败
    public static final String getFailed="failed";
    @RequestMapping("/")
    public String index(Model model){
        Map<String, Object> map = goodService.queryAllGood();
        model.addAttribute("map",map);
        return "index";
    }


    @RequestMapping("/queryGoodByID")
    @ResponseBody
    public String queryGoodByID(@RequestParam("gid") Integer gid){
        Map<String,Object> map=new HashMap<>();
        //从redis查询商品详情,判断redis中是否存在这个商品
        if(redisUtil.hasKey(goodPrefix+gid.toString())){
            //存在返回商品信息
            map.put("data",redisUtil.get(goodPrefix+gid.toString()));
            //返回当前库存
            map.put("stock",redisUtil.get(goodStock+gid.toString()));
            System.out.println("redis里面查出来的");
            return JSON.toJSONString(map);
        }
        //不存在去数据库查，查完存入redis
       Good good=goodService.queryGoodByID(gid);
        redisUtil.set(goodPrefix+gid.toString(),JSON.toJSONString(good));
        redisUtil.set(goodStock+gid.toString(),JSON.toJSONString(good.getStock()));
        map.put("data",JSON.toJSONString(good));
        map.put("stock",JSON.toJSONString(good.getStock()));
        System.out.println("数据库里面查出来的");
        return JSON.toJSONString(map);
    }

    @RequestMapping("/buy")
    @ResponseBody
    public String buy(@RequestParam("uid")Integer uid,@RequestParam("gid")Integer gid){
        Map<String,Object> map=new HashMap<>();
        GoodMessage goodMessage = new GoodMessage();
        goodMessage.setUid(uid);
        goodMessage.setGid(gid);
        try {
            mqUtil.sendQueueMsg(goodMessage);
            map.put("msg",uid+"的订单已经被处理");
            return JSON.toJSONString(map);
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg","MQ传输有问题");
            return JSON.toJSONString(map);
        }
    }

    //接收queue类型消息
    //destination对应配置类中ActiveMQQueue("springboot.queue")设置的名字
    @JmsListener(destination="springboot.queue")
    public void ListenQueue(GoodMessage msg)throws Exception{
        Map<String,Object> map=new HashMap<>();
        System.out.println("接收到queue消息：" + msg);
        //商品加锁,如果添加失败，说明当前有人操作，当前线程休眠10毫秒
        while(!redisUtil.setIfAbsent(lock+msg.getGid(),"yes")){
            Thread.sleep(10);
        }
        //判断当前用户是否购买过
        if(redisUtil.hasKey(getStatus+msg.getUid()+"-"+msg.getGid())){
            if(redisUtil.get(getStatus+msg.getUid()+"-"+msg.getGid()).equals(getSuccess)){
                //购买过并且成功了，删除锁
                redisUtil.delete(lock+msg.getGid());
                System.out.println("请勿重复购买");
                map.put("msg","请勿重复购买");
            }else{
                //购买过但是失败了
                System.out.println("交意失败,稍后再试");
                map.put("msg","交意失败，稍后再试");
            }
        }else{

            //没有购买过，判断库存
            String stock = redisUtil.get(goodStock + msg.getGid());
            Integer integer=new Integer(stock);
            if(integer<=0){
                map.put("msg","库存不足");
                System.out.println("库存不足");
                redisUtil.delete(lock+msg.getGid());
                redisUtil.set(getStatus+msg.getUid()+"-"+msg.getGid(),getFailed);
            }else{
                //有库存，库存减1
                integer-=1;
                redisUtil.set(goodStock+msg.getGid(),integer.toString());
                //删除锁
                redisUtil.delete(lock+msg.getGid());
                //减去库存
                goodService.updateStock(msg.getGid());
                //添加订单
                goodService.addOrder(msg);
                redisUtil.set(getStatus+msg.getUid()+"-"+msg.getGid(),getSuccess);
                System.out.println("购买成功");
                map.put("msg","购买成功");
            }
        }
        webSocket.onMessage(JSON.toJSONString(map));
    }














//    //接收queue类型消息
//    //destination对应配置类中ActiveMQQueue("springboot.queue")设置的名字
//    @JmsListener(destination="springboot.queue")
//    public void ListenQueue(GoodMessage msg){
//        System.out.println("接收到queue消息：" + msg);
//    }

//    //接收topic类型消息
//    //destination对应配置类中ActiveMQTopic("springboot.topic")设置的名字
//    //containerFactory对应配置类中注册JmsListenerContainerFactory的bean名称
//    @JmsListener(destination="springboot.topic", containerFactory = "jmsTopicListenerContainerFactory")
//    public void ListenTopic(GoodMessage msg){
//        System.out.println("接收到topic消息：" + msg);
//    }

}
