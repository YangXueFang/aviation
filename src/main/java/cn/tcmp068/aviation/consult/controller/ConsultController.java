package cn.tcmp068.aviation.consult.controller;

import cn.tcmp068.aviation.consult.services.ConsultServices;
import cn.tcmp068.aviation.entity.Admin;
import cn.tcmp068.aviation.entity.Consult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class ConsultController {
    @Resource
    private ConsultServices consultServices;


    @RequestMapping("listConsultController")
    public String queryAll(Model model, Consult consult,@RequestParam(defaultValue = "1",required = false) int pageNumber,@RequestParam(defaultValue = "7",required = false) int pageSize){
        model.addAttribute("consult",this.consultServices.queryAll(consult,pageNumber,pageSize));
        return "consult";
    }

    @RequestMapping("deleteConsultController")
    public String delete(Model model,int consultId){
        model.addAttribute("consult",this.consultServices.deleteConsult(consultId));
        return "redirect:/listConsultController";
    }

    @RequestMapping("userListConsult")
    public String queryUserAll(Model model,int userId){
        model.addAttribute("consult",this.consultServices.queryAllByuserId(userId));
        return null;
    }
    @RequestMapping("toAddConsultController")
    public String toAdd(){
        return null;
    }
    @RequestMapping("doAddConsultController")
    public String doAdd(Model model,Consult consult,int userId){
        model.addAttribute("consult",this.consultServices.addConsult(consult,userId));
        return null;
    }

    @RequestMapping("detailConsultController")
    public String detail(Model model,int consultId,int userId){
        model.addAttribute("consult",this.consultServices.queryConsultByuserId(consultId,userId));
        return null;
    }
}
