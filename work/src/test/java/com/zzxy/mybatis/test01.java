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
//        a)读取配置文件；
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //b)通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂。
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        // c)通过SqlSessionFactory创建SqlSession。
        SqlSession session = sessionFactory.openSession();

//        d)调用SqlSession的操作数据库方法。
        //查询一条结果
       /* User user = session.selectOne("findUserById",10);
        System.out.println(user);

        //查询多条结果
        List<User> users = session.selectList("findUserByName","张");
        System.out.println(users);*/

        /*//插入用户信息
        session.insert("insertUser", new User("张无忌", new Date(),"男", "明教"));*/

       /* //根据id删除用户
        session.delete("test.deleteUserById", 26);*/

       /*updata user info*/
        User user1 = new User();
        user1.setId(16);
        user1.setUsername("张允浩");
        user1.setSex("女");
        session.update("updateUserInfo", user1);
//      crud除了查询需要提交事务
        session.commit();
    }
}
