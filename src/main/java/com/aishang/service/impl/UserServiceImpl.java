package com.aishang.service.impl;

import com.aishang.dao.IUserDao;
import com.aishang.model.User;
import com.aishang.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    //注入userDao
    private IUserDao userDao;

    public User selectUser(User user) {
        return this.userDao.selectUser(user);
    }

    @Override
    public void registerUser(User user) {
        userDao.registerUser(user);
    }

    @Override
    public User findUserByName(String username) {
        return userDao.findUserByName(username);
    }

    @Override
    public void updateAddr(User user) {
        userDao.updateAddr(user);
    }

    @Override
    public User findUserById(Integer uid) {
        return userDao.findUserById(uid);
    }

    @Override
    public void updatePersonal(User user) {
        userDao.updatePersonal(user);
    }
}