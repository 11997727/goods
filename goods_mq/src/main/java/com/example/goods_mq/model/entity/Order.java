package com.example.goods_mq.model.entity;

import java.util.Date;

/**
 * @Project: goods_mq
 * @Package com.example.goods_mq.entity
 * @Description: ${todo}
 * @author 吴成卓
 * @date 2020/3/12 星期四 20:06
 * @version V1.0 
 *
 */
public class Order {
    private String oid;

    private String uid;

    private Integer gid;

    private Date createdTime;

    public Order() {
    }

    public Order(String oid, String uid, Integer gid, Date createdTime) {
        this.oid = oid;
        this.uid = uid;
        this.gid = gid;
        this.createdTime = createdTime;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}