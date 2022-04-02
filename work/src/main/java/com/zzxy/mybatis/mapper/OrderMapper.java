package com.zzxy.mybatis.mapper;

import com.zzxy.mybatis.entity.Order;
import com.zzxy.mybatis.entity.OrderExt;
import com.zzxy.mybatis.entity.User;

import java.util.List;

public interface OrderMapper {

    public OrderExt findOrderUser(int orderId);


    /**
     * 懒加载用户信息
     * @return
     */
    public List<Order> findOrderUserByLazyloading();

    /**
     * 通过订单id查询订单信息和用户信息
     * @param orderId
     * @return
     */
    public Order findOrderByRstMap(int orderId);


    /**
     * 一对多,通过订单id查询订单信息,用户新信息,订单详情
     * @param orderId
     * @return
     */
    public Order findOrderByRstMapOne2More(int orderId);


}
