package com.ygj.dao.impl;

import org.springframework.stereotype.Repository;

import com.ygj.bean.User;
import com.ygj.dao.LoginDao;
import com.ygj.utils.JDBCUtils;

@Repository
public class LoginDaoImpl implements LoginDao {

    public User login(User user) {
        String sql = "select * from 1701_user where userName = '"+user.getUserName()+"' and passWord = '"+user.getPassWord()+"'";
        user = (User) JDBCUtils.getObjectById(User.class, sql);
        System.out.println(sql);
        return user;
    }

}
