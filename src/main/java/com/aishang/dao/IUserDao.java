package com.aishang.dao;

import com.aishang.model.User;



public interface IUserDao {
    //查询登陆用户是否存在
    User selectUser(User user);

    //注册用户
    void registerUser(User user);

    User findUserByName(String username);

    void updateAddr(User user);

    User findUserById(Integer uid);

    void updatePersonal(User user);
}