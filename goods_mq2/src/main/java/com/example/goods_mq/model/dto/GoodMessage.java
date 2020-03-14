package com.example.goods_mq.model.dto;

import java.io.Serializable;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: goods_mq
 * @Package com.example.goods_mq.model.dto
 * @Description:
 * @date 2020/3/12 星期四 20:34
 */
public class GoodMessage implements Serializable {
    private int uid,gid;

    public GoodMessage() {
    }

    public GoodMessage(int uid, int gid) {
        this.uid = uid;
        this.gid = gid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    @Override
    public String toString() {
        return "GoodMessage{" +
                "uid=" + uid +
                ", gid=" + gid +
                '}';
    }
}
