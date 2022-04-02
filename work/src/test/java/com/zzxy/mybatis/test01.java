package com.zzxy.mybatis;

import com.zzxy.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class test01 {
    @Test
    public void test1() throws IOException {

        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession session = sessionFactory.openSession();

        User user1 = new User();
        user1.setId(16);
        user1.setUsername("张允浩");
        user1.setSex("女");
        session.update("updateUserInfo", user1);

        session.commit();
    }
}
