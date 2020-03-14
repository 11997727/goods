package com.example.goods_mq;

import com.example.goods_mq.model.dto.GoodMessage;
import com.example.goods_mq.util.ActiveMQUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsMqApplicationTests {
    @Resource
    private ActiveMQUtil mqUtil;
    @Test
    public void contextLoads() {
    }

    @Test
    public void queue() {
        GoodMessage goodMessage = new GoodMessage();
        goodMessage.setGid(1);
        goodMessage.setUid(50);
        mqUtil.sendQueueMsg(goodMessage);
    }
    @Test
    public void topic() {
        GoodMessage goodMessage = new GoodMessage();
        goodMessage.setGid(1);
        goodMessage.setUid(50);
        mqUtil.sendTopicMsg(goodMessage);
    }
}
