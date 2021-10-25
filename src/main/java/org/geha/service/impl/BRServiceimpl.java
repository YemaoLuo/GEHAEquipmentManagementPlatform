package org.geha.service.impl;
/*
  User: Yemao Luo
  Date: 2021/10/22
  Time: 9:26
*/

import org.geha.domain.*;
import org.geha.mapper.BRMapper;
import org.geha.mapper.EquipmentMapper;
import org.geha.mapper.UserMapper;
import org.geha.service.BRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BRServiceimpl implements BRService {

    @Autowired
    private BRMapper brMapper;
    @Autowired
    private EquipmentMapper equipmentMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Equipment> findAllNotInUse() {
        return brMapper.findAllNotInUse();
    }

    @Override
    public Msg borrowById(User user, int id) {
        Msg msg = new Msg("借用成功", true);
        Date date = Calendar.getInstance().getTime();
        brMapper.borrowById(user.getId(), id, date, false);
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

    @Override
    public List<BR> BRList() {
        List<BRSQL> BRSQLList = brMapper.findAll();
        List<BR> brList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < BRSQLList.size(); i++) {
            BR br = new BR();
            br.setDate(sdf.format(BRSQLList.get(i).getDate()));
            br.setUname(userMapper.findUserById(BRSQLList.get(i).getUid()).getName());
            if (BRSQLList.get(i).getReturns()) {
                br.setStatus("已归还");
            } else {
                br.setStatus("未归还");
            }
            br.setEname(equipmentMapper.checkExistById(BRSQLList.get(i).getEid()).getName());
            brList.add(br);
        }
        return brList;
    }

    @Override
    public Boolean checkNull() {
        if (brMapper.selectCount() == 0) {
            return false;
        }
        return true;
    }
}
