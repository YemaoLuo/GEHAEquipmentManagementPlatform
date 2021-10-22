package org.geha.mapper;
/*
  User: Yemao Luo
  Date: 2021/10/20
  Time: 9:29
*/

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.geha.domain.Equipment;

import java.util.List;

public interface EquipmentMapper {

    @Select("select * from equipment")
    public List<Equipment> findAll();

    @Select("select * from equipment where name = #{name}")
    public List<Equipment> findEquipmentByName(Equipment equipment);

    @Select("select * from equipment where name = #{name} LIMIT 1")
    public Equipment checkExist(String name);

    @Update("delete from equipment where name = #{name}")
    public void deleteEquipmentByName(String name);

    @Insert("insert into equipment values(null, #{name}, #{inUse})")
    public void insertEquipment(Equipment equipment);

    @Update("update equipment set inUse = #{inUse} where id = #{id}")
    public void updateEquipment(Equipment equipment);

    @Select("select * from equipment where id = #{id}")
    public Equipment checkExistById(int id);

}
