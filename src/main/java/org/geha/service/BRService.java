package org.geha.service;
/*
  User: Yemao Luo
  Date: 2021/10/22
  Time: 9:26
*/

import org.geha.domain.Equipment;
import org.geha.domain.Msg;
import org.geha.domain.User;

import java.util.List;

public interface BRService {

    public List<Equipment> findAllNotInUse();

    public Msg borrowById(User user, int id);
}
