package com.ygj.dao.impl;

import org.springframework.stereotype.Repository;

import com.ygj.bean.User;
import com.ygj.dao.UserDao;
import com.ygj.utils.JDBCUtils;

@Repository
public class UserDaoImpl implements UserDao {

    public int addUser(User user) {
        String sql = "insert into 1701_user set userName = '" + user.getUserName() + "' ,passWord = '"
                + user.getPassWord() + "' ,age = " + user.getAge() + ", sex = '" + user.getSex() + "'";
        int i = JDBCUtils.executeSql(sql);
        return i;
    }

}
