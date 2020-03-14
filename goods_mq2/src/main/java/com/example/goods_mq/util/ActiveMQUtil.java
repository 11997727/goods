package com.example.goods_mq.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: goods_mq
 * @Package com.example.goods_mq.util
 * @Description:
 * @date 2020/3/12 星期四 20:22
 */
@Component
public class ActiveMQUtil {
    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    //发送queue类型消息
    public void sendQueueMsg(Object obj){
        jmsTemplate.convertAndSend(queue, obj);
    }
    //发送topic类型消息
    public void sendTopicMsg(Object obj){
        jmsTemplate.convertAndSend(topic, obj);
    }
}
