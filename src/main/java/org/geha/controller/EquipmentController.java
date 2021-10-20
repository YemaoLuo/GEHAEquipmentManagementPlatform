package org.geha.controller;
/*
  User: Yemao Luo
  Date: 2021/10/20
  Time: 9:29
*/

import org.geha.domain.Equipment;
import org.geha.domain.Msg;
import org.geha.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @RequestMapping("/findAllEquipment")
    public ModelAndView findAllEquipment() {
        ModelAndView modelAndView = new ModelAndView();
        Msg msg = new Msg();
        List<Equipment> equipmentList = equipmentService.findAll();
        if (equipmentList == null) {
            modelAndView.setViewName("/pages/home.jsp");
            msg.setCode(false);
            msg.setMessage("出现未知错误");
            modelAndView.addObject("msg_findAllEquipment");
        } else {
            modelAndView.setViewName("/pages/equipmentList.jsp");
            for (int i = 0; i < equipmentList.size(); i++) {
                if (equipmentList.get(i).getInUse()) {
                    equipmentList.get(i).setInUse_str("在库");
                } else {
                    equipmentList.get(i).setInUse_str("借出");
                }
            }
            modelAndView.addObject("equipmentList", equipmentList);
        }
        return modelAndView;
    }
}
