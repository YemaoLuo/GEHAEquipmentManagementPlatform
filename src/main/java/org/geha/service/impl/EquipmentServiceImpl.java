package org.geha.service.impl;
/*
  User: Yemao Luo
  Date: 2021/10/20
  Time: 9:29
*/

import org.geha.domain.Equipment;
import org.geha.domain.Msg;
import org.geha.mapper.EquipmentMapper;
import org.geha.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentMapper equipmentMapper;

    @Override
    public List<Equipment> findAll() {
        return equipmentMapper.findAll();
    }

    @Override
    public List<Equipment> findEquipmentByName(Equipment equipment) {
        return equipmentMapper.findEquipmentByName(equipment);
    }

    @Override
    public Equipment checkExist(String name) {
        return equipmentMapper.checkExist(name);
    }

    @Override
    public Msg deleteEquipmentByName(String name) {
        Msg msg = new Msg();
        Equipment equipment = equipmentMapper.checkExist(name);
        if (equipment == null) {
            msg.setCode(false);
            msg.setMessage("设备不存在");
        } else {
            equipmentMapper.deleteEquipmentByName(name);
            msg.setCode(true);
            msg.setMessage("删除成功");
        }
        return msg;
    }
}
