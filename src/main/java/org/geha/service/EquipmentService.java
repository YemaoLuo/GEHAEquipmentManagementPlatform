package org.geha.service;
/*
  User: Yemao Luo
  Date: 2021/10/20
  Time: 9:29
*/

import org.geha.domain.Equipment;
import org.geha.domain.Msg;

import java.util.List;

public interface EquipmentService {

    public List<Equipment> findAll();

    public List<Equipment> findEquipmentByName(Equipment equipment);

    public Equipment checkExist(String name);

    public Msg deleteEquipmentByName(String name);

    public void insertEquipment(String name);

    public Msg updateEquipment(Equipment equipment);
}
