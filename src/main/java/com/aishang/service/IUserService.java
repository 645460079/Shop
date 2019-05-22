package com.aishang.service;

import com.aishang.model.User;

public interface IUserService {

     User selectUser(User user);

     void registerUser(User user);

     User findUserByName(String username);

     void updateAddr(User user);

     User findUserById(Integer uid);

    void updatePersonal(User user);

}