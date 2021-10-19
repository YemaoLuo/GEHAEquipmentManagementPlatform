package org.geha.mapper;
/*
  User: Yemao Luo
  Date: 2021/10/18
  Time: 19:24
*/

import org.apache.ibatis.annotations.Select;
import org.geha.domain.User;

import java.util.List;

public interface UserMapper {

    @Select("select * from user where name = #{name} and password = #{password}")
    public User login(User user);

    @Select("select * from user")
    public List<User> findAllUser();

    @Select("select * from user where name = #{name}")
    public User findUserByName(String name);
}
