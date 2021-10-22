package org.geha.service.impl;
/*
  User: Yemao Luo
  Date: 2021/10/22
  Time: 9:26
*/

import org.geha.domain.Equipment;
import org.geha.domain.Msg;
import org.geha.domain.User;
import org.geha.mapper.BRMapper;
import org.geha.mapper.EquipmentMapper;
import org.geha.service.BRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BRServiceimpl implements BRService {

    @Autowired
    private BRMapper brMapper;
    @Autowired
    private EquipmentMapper equipmentMapper;

    @Override
    public List<Equipment> findAllNotInUse() {
        return brMapper.findAllNotInUse();
    }

    @Override
    public Msg borrowById(User user, int id) {
        Msg msg = new Msg("借用成功", true);
        brMapper.borrowById(user.getId(), id, new Date(), false);
        return msg;
    }

    @Override
    public Msg returnById(User user, int id) {
        Msg msg = new Msg("归还成功", true);
        brMapper.returnById(id, true);
        Equipment equipment = new Equipment();
        equipment.setId(id);
        equipment.setInUse(true);
        equipmentMapper.updateEquipment(equipment);
        return msg;
    }

    @Override
    public List<Equipment> notREquipment(User user) {
        List<Integer> byId = brMapper.findById(user.getId());
        List<Equipment> equipmentList = new ArrayList<Equipment>();
        if (byId.size() == 0) {
            return null;
        }
        int eid = 0;
        for (int i = 0; i < byId.size(); i++) {
            eid = byId.get(i);
            equipmentList.add(equipmentMapper.checkExistById(eid));
        }
        return equipmentList;
    }
}
