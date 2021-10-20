package org.geha.mapper;
/*
  User: Yemao Luo
  Date: 2021/10/20
  Time: 9:29
*/

import org.apache.ibatis.annotations.Select;
import org.geha.domain.Equipment;

import java.util.List;

public interface EquipmentMapper {

    @Select("select * from equipment")
    public List<Equipment> findAll();

    @Select("select * from equipment where name = #{name}")
    public List<Equipment> findEquipmentByName(Equipment equipment);

    @Select("select * from equipment where name = #{name} LIMIT 1")
    public Equipment checkExist(String name);
}
