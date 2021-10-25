package org.geha.mapper;
/*
  User: Yemao Luo
  Date: 2021/10/22
  Time: 9:25
*/

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.geha.domain.BRSQL;
import org.geha.domain.Equipment;

import java.util.Date;
import java.util.List;

public interface BRMapper {

    @Select("select * from equipment where inUse = 1")
    public List<Equipment> findAllNotInUse();

    @Insert("insert into br values(#{uid}, #{eid}, #{date}, #{returns})")
    public void borrowById(@Param("uid") int uid, @Param("eid") int eid, @Param("date") Date date, @Param("returns") Boolean return_s);

    @Update("update br set returns = #{returns} where eid = #{eid}")
    public void returnById(@Param("eid") int eid, @Param("returns") Boolean returns);

    @Select("select eid from br where uid = #{uid} and returns = 0")
    public List<Integer> findById(@Param("uid") int id);

    @Select("select * from br")
    public List<BRSQL> findAll();

    @Select("select count(*) from br")
    public int selectCount();
}
