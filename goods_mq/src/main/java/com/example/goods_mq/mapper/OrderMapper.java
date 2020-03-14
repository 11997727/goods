package com.example.goods_mq.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Project: goods_mq
 * @Package com.example.goods_mq.mapper
 * @Description: ${todo}
 * @author 吴成卓
 * @date 2020/3/12 星期四 20:06
 * @version V1.0 
 *
 */
@Mapper
public interface OrderMapper {

    Integer addOrder(@Param("userid") Integer uid, @Param("goodid") Integer gid);
}