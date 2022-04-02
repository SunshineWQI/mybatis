package com.zzxy.mybatis;

import com.zzxy.mybatis.entity.Order;
import com.zzxy.mybatis.entity.OrderExt;
import com.zzxy.mybatis.entity.Orderdetail;
import com.zzxy.mybatis.entity.User;
import com.zzxy.mybatis.mapper.OrderMapper;
import com.zzxy.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test05 {
    SqlSession session;

    @Before
    public void before() throws IOException {
//        a)读取配置文件；
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //b)通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂。
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        session = sessionFactory.openSession();

    }

    @After
    public void after() {
        session.close();
    }

    /**
     *一对一
     */
    @Test
    public void test1() {
        OrderMapper mapper = session.getMapper(OrderMapper.class);

        OrderExt orderUser = mapper.findOrderUser(3);
        System.out.println(orderUser);
    }

    /**
     * 一对一的resultMap实现
     */
    @Test
    public void test2() {
        OrderMapper mapper = session.getMapper(OrderMapper.class);

        Order order= mapper.findOrderByRstMap(3);
        System.out.println(order);
        System.out.println(order.getUser());
    }

    /**
     * 一对多
     */
    @Test
    public void test3() {
        OrderMapper mapper = session.getMapper(OrderMapper.class);

        Order order = mapper.findOrderByRstMapOne2More(3);
        System.out.println(order);
    }

    /**
     * 多对多
     */
    @Test
    public void test4() {
        UserMapper mapper = session.getMapper(UserMapper.class);

        List<User> users = mapper.findUserAndItemByRstMap();
        for (User user : users) {
            System.out.println(user);
            for (Order order : user.getOrderList()) {
                System.out.println(order);
                for (Orderdetail orderdetail : order.getOrderDetails()) {
                    System.out.println(orderdetail);
                }
                System.out.println("-----------------------------------");
            }
        }
    }

    /**
     * 懒加载
     */
    @Test
    public void test5() {
        OrderMapper mapper = session.getMapper(OrderMapper.class);

        List<Order> orderList = mapper.findOrderUserByLazyloading();
        for (Order order : orderList) {
            //在打印之前,输出sql语句,说明是懒加载
            System.out.println(order.getUser());
            System.out.println("------------------------");
        }
    }

}
