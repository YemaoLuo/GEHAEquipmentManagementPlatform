package org.geha.controller;
/*
  User: Yemao Luo
  Date: 2021/10/18
  Time: 16:15
*/

import org.geha.domain.Msg;
import org.geha.domain.User;
import org.geha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ModelAndView login(User login_user, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Msg msg = new Msg();
        User user = userService.login(login_user);
        if (user == null) {
            msg.setCode(false);
            msg.setMessage("账号或密码错误!");
            modelAndView.addObject("msg", msg);
            //重定向不然报错 估计是循环提交错误post信息
            modelAndView.setViewName("login");
        } else {
            session.setAttribute("user", user);
            modelAndView.addObject("user", user);
            modelAndView.setViewName("home");
        }
        return modelAndView;
    }
}
