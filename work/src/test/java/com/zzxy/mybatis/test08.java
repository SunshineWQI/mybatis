package com.zzxy.mybatis;

import com.zzxy.mybatis.entity.Item;
import com.zzxy.mybatis.entity.ItemExample;
import com.zzxy.mybatis.mapper.ItemMapper;
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

public class test08 {
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
     *测试使用逆向工程生产的代码
     */
    @Test
    public void test1() {
        ItemMapper mapper = session.getMapper(ItemMapper.class);
        ItemExample example = new ItemExample();
        ItemExample.Criteria criteria = example.createCriteria();
        criteria.andNameLike("%背包%");
        List<Item> items = mapper.selectByExample(example);
        for (Item item : items) {
            System.out.println(item);
        }


    }
}
