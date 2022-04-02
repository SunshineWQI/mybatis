package com.zzxy.mybatis.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    private static final long serialVersionUID = -34833785721971937L;

    private Integer id;
    /**
     * 下单用户id
     */
    private Integer userId;
    /**
     * 订单号
     */
    private String number;
    /**
     * 创建订单时间
     */
    private Date createtime;
    /**
     * 备注
     */
    private String note;

    /**
     * 嵌套User对象
     * @return
     */
    private  User user;

    /**
     * 添加订单详情
     */
    private List<Orderdetail> orderDetails;

    public List<Orderdetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<Orderdetail> orderdetails) {
        this.orderDetails = orderdetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", number='" + number + '\'' +
                ", createtime=" + createtime +
                ", note='" + note + '\'' +
                ", orderDetail=" + orderDetails +
                '}';
    }
}