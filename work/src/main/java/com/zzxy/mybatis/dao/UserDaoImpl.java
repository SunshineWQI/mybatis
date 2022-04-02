package com.zzxy.mybatis.dao;

import com.zzxy.mybatis.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


public class UserDaoImpl implements IUserDao {
    //注入SqlSessionFactory
    SqlSessionFactory ssf;

    public UserDaoImpl() {
    }

    public UserDaoImpl(SqlSessionFactory ssf) {
        this.ssf = ssf;
    }

    @Override
    public void save(User user) {
        SqlSession sqlSession = ssf.openSession();
        sqlSession.insert("insertUser", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public User findUserById(int id) {
        SqlSession sqlSession = ssf.openSession();
        User user = sqlSession.selectOne("findUserById", id);
        System.out.println(user);
        sqlSession.close();
        return user;
    }
}
