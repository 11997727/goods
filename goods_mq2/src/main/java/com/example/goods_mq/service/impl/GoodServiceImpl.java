package com.example.goods_mq.service.impl;

import com.example.goods_mq.mapper.GoodMapper;
import com.example.goods_mq.mapper.OrderMapper;
import com.example.goods_mq.model.dto.GoodMessage;
import com.example.goods_mq.model.entity.Good;
import com.example.goods_mq.service.GoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: goods_mq
 * @Package com.example.goods_mq.service.impl
 * @Description:
 * @date 2020/3/12 星期四 21:53
 */
@Service
public class GoodServiceImpl implements GoodService {
    @Resource
    private GoodMapper goodMapper;
    @Resource
    private OrderMapper orderMapper;
    @Override
    public Map<String, Object> queryAllGood() {
        Map<String,Object>map=new HashMap<>();
        map.put("code",2004);
        List<Good> goods = goodMapper.selectAllGood();
        if(goods!=null&&goods.size()>0){
            map.put("code",2001);
            map.put("data",goods);
        }
        return map;
    }

    @Override
    public Good queryGoodByID(Integer gid) {
        return goodMapper.selectGoodByID(gid);
    }

    @Override
    public boolean updateStock(int gid) {
        if(goodMapper.updateStock(gid)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean addOrder(GoodMessage msg) {
        if(orderMapper.addOrder(msg.getUid(),msg.getGid())>0){
            return true;
        }
        return false;
    }
}
