package org.geha.service;
/*
  User: Yemao Luo
  Date: 2021/10/18
  Time: 16:41
*/

import org.geha.domain.User;

import java.util.List;

public interface UserService {

    public User login(User user);

    public List<User> findAllUser();

    public User findUserByName(String name);
}
