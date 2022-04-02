package com.zzxy.mybatis;

import com.zzxy.mybatis.entity.User;
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
import java.util.Date;


public class test06 {
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
     *一级缓存:session级别的, Mybatis默认的
     */
    @Test
    public void test1() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user1 = mapper.findUserById(16);
        System.out.println(user1);

        //不会执行sql
        User user2 = mapper.findUserById(16);
        System.out.println(user2);

    }

    /**
     * 一级缓存:session级别的, Mybatis默认的
     * 新增/删除/更新后, 缓存被清除
     */
    @Test
    public void test2() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user1 = mapper.findUserById(16);
        System.out.println(user1);

        mapper.save(new User("LiBai", new Date(), "1", "兰陵"));
        session.commit();
        //会执行sql
        User user2 = mapper.findUserById(16);
        System.out.println(user2);

    }


}
