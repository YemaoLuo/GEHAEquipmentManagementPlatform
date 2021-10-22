package org.geha.controller;
/*
  User: Yemao Luo
  Date: 2021/10/22
  Time: 9:26
*/

import org.geha.domain.Equipment;
import org.geha.domain.Msg;
import org.geha.domain.User;
import org.geha.service.BRService;
import org.geha.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RequestMapping("/br")
@Controller
public class BRController {

    @Autowired
    private BRService brService;
    @Autowired
    private EquipmentService equipmentService;

    @RequestMapping("/BRCRUDPage")
    public ModelAndView BRCRUDPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/pages/BRCRUD.jsp");
        modelAndView.addObject("NotInUseList", brService.findAllNotInUse());
        return modelAndView;
    }

    @RequestMapping("/bEquipment")
    public ModelAndView bEquipment(int id, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");
        Msg msg = brService.borrowById(user, id);
        modelAndView.setViewName("/pages/BRCRUD.jsp");
        Equipment equipment = new Equipment();
        equipment.setId(id);
        equipment.setInUse(Boolean.FALSE);
        equipmentService.updateEquipment(equipment);
        modelAndView.addObject("msg_bEquipment", msg);
        modelAndView.addObject("NotInUseList", brService.findAllNotInUse());
        return modelAndView;
    }
}
