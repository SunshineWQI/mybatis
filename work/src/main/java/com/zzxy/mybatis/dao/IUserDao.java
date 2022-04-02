package com.zzxy.mybatis.dao;

import com.zzxy.mybatis.entity.User;

public interface IUserDao {
    public void save(User user);

    public User findUserById(int id);
}
