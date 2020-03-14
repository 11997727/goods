package com.example.goods_mq.model.entity;

/**
 * @Project: goods_mq
 * @Package com.example.goods_mq.entity
 * @Description: ${todo}
 * @author 吴成卓
 * @date 2020/3/12 星期四 20:00
 * @version V1.0 
 *
 */
public class Good {
    private Integer gid;

    private String gname;

    private String gtitle;

    private String gdesc;

    private String picture;

    private Integer stock;

    private Double originalPrice;

    private Double price;

    public Good() {
    }

    public Good(Integer gid, String gname, String gtitle, String gdesc, String picture, Integer stock, Double originalPrice, Double price) {
        this.gid = gid;
        this.gname = gname;
        this.gtitle = gtitle;
        this.gdesc = gdesc;
        this.picture = picture;
        this.stock = stock;
        this.originalPrice = originalPrice;
        this.price = price;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGtitle() {
        return gtitle;
    }

    public void setGtitle(String gtitle) {
        this.gtitle = gtitle;
    }

    public String getGdesc() {
        return gdesc;
    }

    public void setGdesc(String gdesc) {
        this.gdesc = gdesc;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}