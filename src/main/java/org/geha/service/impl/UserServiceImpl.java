package org.geha.service.impl;
/*
  User: Yemao Luo
  Date: 2021/10/18
  Time: 19:15
*/

import org.geha.dao.UserDao;
import org.geha.domain.User;
import org.geha.mapper.UserMapper;
import org.geha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMapper userMapper;

    public User login(User user) {
        return userDao.login(user);
    }
}
