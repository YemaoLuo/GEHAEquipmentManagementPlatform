package org.geha.mapper;
/*
  User: Yemao Luo
  Date: 2021/10/22
  Time: 9:25
*/

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.geha.domain.Equipment;

import java.util.Date;
import java.util.List;

public interface BRMapper {

    @Select("select * from equipment where inUse = 1")
    public List<Equipment> findAllNotInUse();

    @Insert("insert into br values(#{uid}, #{eid}, #{date}, #{return})")
    public void borrowById(@Param("uid") int uid, @Param("eid") int eid, @Param("date") Date date, @Param("return") Boolean return_s);
}
