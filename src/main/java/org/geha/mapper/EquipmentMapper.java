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
}
