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
            modelAndView.setViewName("/login.jsp");
        } else {
            session.setAttribute("user", user);
            modelAndView.addObject("user", user);
            modelAndView.setViewName("/pages/home.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/findAllUser")
    public ModelAndView findAllUser(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Msg msg = new Msg();
        User user = (User) session.getAttribute("user");
        if (user.getRole().equals("管理员")) {
            modelAndView.setViewName("/pages/userList.jsp");
            modelAndView.addObject("userList", userService.findAllUser());
            return modelAndView;
        } else {
            msg.setCode(false);
            msg.setMessage("您没有权限");
            modelAndView.addObject("msg_findAllUser", msg);
            modelAndView.setViewName("/pages/home.jsp");
            return modelAndView;
        }
    }

    @RequestMapping("/userCRUDPage")
    public ModelAndView userCRUDPage(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Msg msg = new Msg();
        User user = (User) session.getAttribute("user");
        if (user.getRole().equals("管理员")) {
            modelAndView.setViewName("/pages/userCRUD.jsp");
            return modelAndView;
        } else {
            msg.setCode(false);
            msg.setMessage("您没有权限");
            modelAndView.addObject("msg_userCRUD", msg);
            modelAndView.setViewName("/pages/home.jsp");
            return modelAndView;
        }
    }

    @RequestMapping("/findUserByName")
    public ModelAndView findUserByName(String name) {
        ModelAndView modelAndView = new ModelAndView();
        Msg msg = new Msg();
        User user = userService.findUserByName(name);
        if (user == null) {
            msg.setCode(false);
            msg.setMessage("无此用户信息");
            modelAndView.addObject("msg_findUserByName", msg);
            modelAndView.setViewName("/pages/userCRUD.jsp");
        } else {
            modelAndView.addObject("user_search", user);
            modelAndView.setViewName("/pages/userCRUD.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/deleteUserByName")
    public ModelAndView deleteUserByName(String name) {
        ModelAndView modelAndView = new ModelAndView();
        Msg msg = new Msg();
        User user = userService.findUserByName(name);
        if (user != null) {
            userService.deleteUserByName(name);
            msg.setMessage("删除成功");
            modelAndView.addObject("msg_deleteUserByName", msg);
            modelAndView.setViewName("/pages/userCRUD.jsp");
        } else {
            msg.setCode(false);
            msg.setMessage("无此用户信息");
            modelAndView.addObject("msg_deleteUserByName", msg);
            modelAndView.setViewName("/pages/userCRUD.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/insertUser")
    public ModelAndView insertUser(User user) {
        ModelAndView modelAndView = new ModelAndView();
        Msg msg = userService.insertUser(user);
        modelAndView.setViewName("/pages/userCRUD.jsp");
        modelAndView.addObject("msg_insertUser", msg);
        return modelAndView;
    }

    @RequestMapping("/updateUser")
    public ModelAndView updateUser(User user) {
        ModelAndView modelAndView = new ModelAndView();
        Msg msg = userService.updateUser(user);
        modelAndView.setViewName("/pages/userCRUD.jsp");
        modelAndView.addObject("msg_updateUser", msg);
        return modelAndView;
    }

    @RequestMapping("/changePasswordByName")
    public ModelAndView changePasswordByName(String password, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");
        user.setPassword(password);
        Msg msg = userService.changePasswordByName(user);
        modelAndView.setViewName("/pages/home.jsp");
        modelAndView.addObject("msg_changePasswordByName", msg);
        return modelAndView;
    }

    @RequestMapping("/toHome")
    public ModelAndView toHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/pages/home.jsp");
        return modelAndView;
    }
}
