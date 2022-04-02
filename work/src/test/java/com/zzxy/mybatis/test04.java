package com.zzxy.mybatis;

import com.zzxy.mybatis.entity.User;
import com.zzxy.mybatis.mapper.UserMapper;
import com.zzxy.mybatis.vo.UserQueryVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test04 {
    SqlSession session;

    @Before
    public void before() throws IOException {
//        a)读取配置文件；
        InputStream is = Resources.getResourceAsStream("./SqlMapConfig.xml");

        //b)通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂。
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        session = sessionFactory.openSession();
        System.out.println("before....");

    }

    @After
    public void after() {
        session.close();
        System.out.println("after...");
    }

    @Test
    public void test() {
        UserMapper mapper = session.getMapper(UserMapper.class);

       /* UserQueryVO vo = new UserQueryVO();
        User user = new User();
        user.setUsername("王");

        Orders order = new Orders();
        order.setNumber("1000010");

        vo.setUser(user);
        vo.setOrders(order);

        List<User> users = mapper.findUserListByVO(vo);
        System.out.println(users);*/

        Map<String, Object> map = new HashMap<>();
        map.put("username", "张无忌");
        map.put("sex", "女");
        List<User> users = mapper.findUserListByMap(map);
        System.out.println(users);
        session.commit();

    }

    @Test
    public void test1() {
        UserMapper mapper = session.getMapper(UserMapper.class);

        UserQueryVO vo = new UserQueryVO();
        User user = new User();
        user.setSex("1");

        vo.setUser(user);

        int count = mapper.findUserCount(vo);
        System.out.println(" man counts : " + count);
        session.commit();
    }

    /**
     * resultMap简单测试
     */
    @Test
    public void test2() {
        UserMapper mapper = session.getMapper(UserMapper.class);

        User user = mapper.findUserByIdResultMap(1);
        System.out.println(user);
        session.commit();
    }

    /**
     * 测试动态sql
     */
    @Test
    public void test3() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserQueryVO vo = new UserQueryVO();
        User user = new User();
        user.setSex("1");
        user.setUsername("张");
        vo.setUser(user);
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(10);
        ids.add(22);
        vo.setIds(ids);
        List<User> list = mapper.findUserList(vo);
        System.out.println(list);
    }

    /**
     * 测试参数遍历
     */
    @Test
    public void test4() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(10);
        ids.add(22);
        /*随意修改,测试git上传*/
        List<User> list = mapper.findUserByList(ids);
        System.out.println(list);
    }
}
