package com.zzxy.mybatis.entity;

import java.io.Serializable;


public class Orderdetail implements Serializable {
    private static final long serialVersionUID = -70082308972437622L;

    private Integer id;
    /**
     * 订单id
     */
    private Integer ordersId;
    /**
     * 商品id
     */
    private Integer itemsId;
    /**
     * 商品购买数量
     */
    private Integer itemsNum;

    //item
    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public Integer getItemsId() {
        return itemsId;
    }

    public void setItemsId(Integer itemsId) {
        this.itemsId = itemsId;
    }

    public Integer getItemsNum() {
        return itemsNum;
    }

    public void setItemsNum(Integer itemsNum) {

        this.itemsNum = itemsNum;
    }

    @Override
    public String toString() {
        return "Orderdetail{" +
                "id=" + id +
                ", ordersId=" + ordersId +
                ", itemsId=" + itemsId +
                ", itemsNum=" + itemsNum +
                ", item=" + item +
                '}';
    }

}