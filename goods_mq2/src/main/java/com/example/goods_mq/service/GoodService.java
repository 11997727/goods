package com.example.goods_mq.service;

import com.example.goods_mq.model.dto.GoodMessage;
import com.example.goods_mq.model.entity.Good;

import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: goods_mq
 * @Package com.example.goods_mq.service
 * @Description:
 * @date 2020/3/12 星期四 21:52
 */
public interface GoodService {
    Map<String,Object> queryAllGood();

    Good queryGoodByID(Integer gid);

    boolean updateStock(int gid);

    boolean addOrder(GoodMessage msg);
}
