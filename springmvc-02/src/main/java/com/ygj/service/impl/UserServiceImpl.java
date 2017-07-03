package com.ygj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ygj.bean.User;
import com.ygj.dao.UserDao;
import com.ygj.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public int addUser(User user) {
        return this.userDao.addUser(user);
    }

}
