package org.geha.controller;
/*
  User: Yemao Luo
  Date: 2021/10/20
  Time: 9:29
*/

import org.geha.domain.Equipment;
import org.geha.domain.Msg;
import org.geha.domain.User;
import org.geha.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    //转换01->状态
    public List<Equipment> addInUse_str(List<Equipment> equipmentList) {
        for (int i = 0; i < equipmentList.size(); i++) {
            if (equipmentList.get(i).getInUse()) {
                equipmentList.get(i).setInUse_str("在库");
            } else {
                equipmentList.get(i).setInUse_str("借出");
            }
        }
        return equipmentList;
    }

    @RequestMapping("/findAllEquipment")
    public ModelAndView findAllEquipment() {
        ModelAndView modelAndView = new ModelAndView();
        Msg msg = new Msg();
        List<Equipment> equipmentList = equipmentService.findAll();
        if (equipmentList == null) {
            modelAndView.setViewName("/pages/home.jsp");
            msg.setCode(false);
            msg.setMessage("出现未知错误");
            modelAndView.addObject("msg_findAllEquipment", msg);
        } else {
            modelAndView.setViewName("/pages/equipmentList.jsp");
            equipmentList = addInUse_str(equipmentList);
            modelAndView.addObject("equipmentList", equipmentList);
        }
        return modelAndView;
    }

    @RequestMapping("/equipmentCRUDPage")
    public ModelAndView equipmentCRUDPage(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Msg msg = new Msg();
        User user = (User) session.getAttribute("user");
        if (user.getRole().equals("管理员")) {
            modelAndView.setViewName("/pages/equipmentCRUD.jsp");
            return modelAndView;
        } else {
            msg.setCode(false);
            msg.setMessage("您没有权限");
            modelAndView.addObject("msg_equipmentCRUD", msg);
            modelAndView.setViewName("/pages/home.jsp");
            return modelAndView;
        }
    }

    @RequestMapping("/findEquipmentByName")
    public ModelAndView findEquipmentByName(Equipment equipment) {
        ModelAndView modelAndView = new ModelAndView();
        Msg msg = new Msg();
        Equipment equipmentExist = equipmentService.checkExist(equipment.getName());
        if (equipmentExist != null) {
            List<Equipment> equipmentByName = equipmentService.findEquipmentByName(equipment);
            equipmentByName = addInUse_str(equipmentByName);
            modelAndView.setViewName("/pages/equipmentCRUD.jsp");
            modelAndView.addObject("equipment_findEquipmentByName", equipmentByName);
        } else {
            msg.setCode(false);
            msg.setMessage("设备不存在");
            modelAndView.setViewName("/pages/equipmentCRUD.jsp");
            modelAndView.addObject("msg_findEquipmentByName", msg);
        }
        return modelAndView;
    }

    @RequestMapping("/toHome")
    public ModelAndView toHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/pages/home.jsp");
        return modelAndView;
    }

    @RequestMapping("/deleteEquipmentByName")
    public ModelAndView deleteEquipmentByName(String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/pages/equipmentCRUD.jsp");
        Msg msg = equipmentService.deleteEquipmentByName(name);
        modelAndView.addObject("msg_deleteEquipmentByName", msg);
        return modelAndView;
    }

    @RequestMapping("/insertEquipment")
    public ModelAndView insertEquipment(String name) {
        ModelAndView modelAndView = new ModelAndView();
        equipmentService.insertEquipment(name);
        Msg msg = new Msg("添加成功", true);
        modelAndView.setViewName("/pages/equipmentCRUD.jsp");
        modelAndView.addObject("msg_insertEquipment", msg);
        return modelAndView;
    }
}
