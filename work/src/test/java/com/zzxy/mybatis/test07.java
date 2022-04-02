package com.zzxy.mybatis;

import com.zzxy.mybatis.entity.User;
import com.zzxy.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class test07 {
    /**
     * 二级缓存:sessionFactory级别的,默认是perpetualCache
     * session close写入缓存,新增/删除/更新提交后,删除缓存
     */
    @Test
    public void test3() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);

        SqlSession session1 = ssf.openSession();
        SqlSession session2 = ssf.openSession();
        SqlSession session3 = ssf.openSession();

        UserMapper mapper1 = session1.getMapper(UserMapper.class);
        UserMapper mapper2 = session2.getMapper(UserMapper.class);
        UserMapper mapper3 = session3.getMapper(UserMapper.class);

        User user1 = mapper1.findUserById(16);
        System.out.println(user1);
        //写入二级缓存
        session1.close();

        //进行增加操作, commit后清除二级缓存
        /*mapper3.save(new User("Lan", new Date(), "1", "山东"));
        session3.commit();*/

        User user2 = mapper2.findUserById(16);
        //不会再执行sql
        //上面有新增操作,会执行sql
        System.out.println(user2);
        session2.close();
        session3.close();
    }
}
