package com.zzxy.mybatis.vo;

import com.zzxy.mybatis.entity.Orders;
import com.zzxy.mybatis.entity.User;

import java.util.List;

public class UserQueryVO {
    private User user;
    private Orders orders;

    /*添加一个ids集合,以及其get和set的方法*/
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
