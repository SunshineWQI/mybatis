package com.zzxy.mybatis;

import com.zzxy.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
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
public class test02 {
    SqlSession session;
    @Before
    public void test1() throws IOException {
//        a)读取配置文件；
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //b)通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂。
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        // c)通过SqlSessionFactory创建SqlSession。
        session = sessionFactory.openSession();
    }

    @Test
    public void test2() {
        User user = new User("jjy1",new Date(),"女","枣庄");
        int affectRows = session.insert("insertUser2", user);
        System.out.println("受影响的行数: " + affectRows);
        System.out.println("返回的主键: " + user.getId());
        session.commit();
    }
}
