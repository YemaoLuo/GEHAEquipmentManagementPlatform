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
import org.geha.service.BRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BRServiceimpl implements BRService {

    @Autowired
    private BRMapper brMapper;


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
}
