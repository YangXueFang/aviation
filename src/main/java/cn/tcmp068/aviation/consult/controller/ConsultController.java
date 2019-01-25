package cn.tcmp068.aviation.consult.controller;

import cn.tcmp068.aviation.consult.services.ConsultServices;
import cn.tcmp068.aviation.entity.Admin;
import cn.tcmp068.aviation.entity.Consult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class ConsultController {
    @Resource
    private ConsultServices consultServices;


    @RequestMapping("listConsultController")
    public String queryAll(Model model,String consultPhone,String consultText, Consult consult,@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10",required = false) int pageSize){

        if(consultPhone!=null || consultText!=null){
            Consult c=new Consult();
            c.setConsultPhone(consultPhone);
            c.setConsultText(consultText);
            System.out.println(c+"=========================================>");
            model.addAttribute("consult", this.consultServices.queryAll(c, pageNum, pageSize));
        }else{
            System.out.println(pageNum+"++++++++++++++++++++++++++++++++ ");
            model.addAttribute("consult", this.consultServices.queryAll(consult, pageNum, pageSize));
        }
        return "consult";
    }

    @RequestMapping("deleteConsultController")
    public String delete(Model model,int consultId){
        model.addAttribute("consult",this.consultServices.deleteConsult(consultId));
        return "redirect:/listConsultController";
    }

    @RequestMapping("userListConsult")
    public String queryUserAll(Model model,@RequestParam(defaultValue = "1",required = false)int userId){
        model.addAttribute("consult",this.consultServices.queryAllByuserId(1));
        return "userConsult";
    }
    @RequestMapping("toAddConsultController")
    public String toAdd(){
        return "addConsult";
    }
    @RequestMapping("doAddConsultController")
    public String doAdd(Model model,Consult consult){
        model.addAttribute("consult",this.consultServices.addConsult(consult));
        return "about";
    }

    @RequestMapping("detailConsultController")
    public String detail(Model model,int consultId){
        model.addAttribute("consult",this.consultServices.queryConsultByuserId(consultId));
        return "detailConsult";
    }
    /////////手机端
    @RequestMapping("detailConsultPhone")
    @ResponseBody
    public Consult detailPhone(int consultId){
        return this.consultServices.queryConsultByuserId(consultId);
    }
}
