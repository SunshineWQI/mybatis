package com.zzxy.mybatis.mapper;

import com.zzxy.mybatis.entity.User;
import com.zzxy.mybatis.vo.UserQueryVO;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    public int save(User user);

    public User findUserById(int id);

    public List<User> findUserListByVO(UserQueryVO vo);

    public int findUserCount(UserQueryVO vo);

    public List<User> findUserListByMap(Map<String, Object> map);

    public User findUserByIdResultMap(int id);

    public List<User> findUserList(UserQueryVO vo);
    /*另外一种遍历*/
    public List<User> findUserByList(List<Integer> ids);

    /**
     * 多对多, 查询用户信息以及商品信息
     * @return
     */
    public List<User> findUserAndItemByRstMap();

}