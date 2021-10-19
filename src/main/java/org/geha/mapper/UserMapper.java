package org.geha.mapper;
/*
  User: Yemao Luo
  Date: 2021/10/18
  Time: 19:24
*/

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

    @Delete("delete from user where name = #{name}")
    public void deleteUserByName(String name);

    @Insert("insert into user values(null, #{name}, #{gender}, #{role}, #{year},  #{password}, #{email}, #{phone})")
    public void insertUser(User user);
}
