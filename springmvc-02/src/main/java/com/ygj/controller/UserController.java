package com.ygj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ygj.bean.User;
import com.ygj.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    //跳转到添加用户界面
    @RequestMapping("addUserPage")
    public String addUserPage() {
        return "addUser";
    }
    //添加用户功能
    @RequestMapping("addUser")
    public ModelAndView addUser(User user,ModelAndView mv){
        int i = this.userService.addUser(user);
        if(i>0){
            mv.setViewName("redirect:/index.jsp");
        }
        return mv;
    }
    
    
}
