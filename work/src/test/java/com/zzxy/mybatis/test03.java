package com.zzxy.mybatis;

import com.zzxy.mybatis.dao.UserDaoImpl;
import com.zzxy.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by aven on 2021/1/26 23:01
 */
public class test03 {
    SqlSessionFactory sessionFactory;

    @Before
    public void before() throws IOException {
//        a)读取配置文件；
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //b)通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂。
        sessionFactory = new SqlSessionFactoryBuilder().build(is);

    }

    @Test
    public void test2() {
        UserDaoImpl userDao = new UserDaoImpl(sessionFactory);
        userDao.findUserById(16);

        userDao.save(new User("孙文琪",new Date(),"女", "枣庄"));
    }
}
