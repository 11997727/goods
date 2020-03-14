package com.example.goods_mq.mapper;

import com.example.goods_mq.model.entity.Good;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Project: goods_mq
 * @Package com.example.goods_mq.mapper
 * @Description: ${todo}
 * @author 吴成卓
 * @date 2020/3/12 星期四 20:00
 * @version V1.0 
 *
 */
@Mapper
public interface GoodMapper {
    /**
     * 展示商品列表
     * @return
     */
        List<Good>selectAllGood();

    Good selectGoodByID(Integer gid);

    Integer updateStock(int gid);


}