package com.ygj.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ygj.bean.User;
import com.ygj.service.LoginService;

@Controller
@RequestMapping("login")
public class LoginAction {
    @Autowired
    private LoginService loginService;

    //登录功能
    @RequestMapping("login")
    @ResponseBody
    public Map<String, Object> login(User user) {        
        Map<String, Object> map = new HashMap<String, Object>();
        user = this.loginService.login(user);
        if(user == null){
            map.put("error", "用户名或密码输入错误！");
        }
        return map;
    }
}
