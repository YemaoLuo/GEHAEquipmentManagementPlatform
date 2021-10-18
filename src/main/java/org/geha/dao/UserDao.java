package org.geha.dao;
/*
  User: Yemao Luo
  Date: 2021/10/18
  Time: 16:38
*/

import org.geha.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User login(User user) {
        User login_user = null;
        try {
            login_user = jdbcTemplate.queryForObject("select * from user where name = ? and password = ?", new BeanPropertyRowMapper<User>(User.class), user.getName(), user.getPassword());
        } catch (Exception e) {
            return null;
        }
        return login_user;
    }
}
