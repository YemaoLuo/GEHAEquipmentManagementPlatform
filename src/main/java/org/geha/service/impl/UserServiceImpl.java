package org.geha.service.impl;
/*
  User: Yemao Luo
  Date: 2021/10/18
  Time: 19:15
*/

import org.geha.domain.Msg;
import org.geha.domain.User;
import org.geha.mapper.UserMapper;
import org.geha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public User findUserByName(String name) {
        return userMapper.findUserByName(name);
    }

    @Override
    public void deleteUserByName(String name) {
        userMapper.deleteUserByName(name);
    }

    @Override
    public Msg insertUser(User user) {
        Msg msg = new Msg();
        User userByName = userMapper.findUserByName(user.getName());
        if (userByName != null) {
            msg.setCode(false);
            msg.setMessage("用户名已存在");
            return msg;
        } else {
            userMapper.insertUser(user);
            msg.setCode(true);
            msg.setMessage("添加成功");
            return msg;
        }

    }
}
