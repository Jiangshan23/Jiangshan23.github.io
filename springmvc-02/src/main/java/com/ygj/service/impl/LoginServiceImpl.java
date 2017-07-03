package com.ygj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ygj.bean.User;
import com.ygj.dao.LoginDao;
import com.ygj.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    public User login(User user) {
        // TODO Auto-generated method stub
        return this.loginDao.login(user);
    }

}
