package cn.tcmp068.aviation.admin.controller;

import cn.tcmp068.aviation.admin.services.AdminServices;
import cn.tcmp068.aviation.entity.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class AdminController {
    @Resource
    private AdminServices adminServices;

    @RequestMapping("admin")
    public String admin(){
        return "admin";
    }
    @RequestMapping("listAdminController")
    public String queryAll(Model model){
        model.addAttribute("admin",this.adminServices.queryAll());
        return "admin";
    }
    @RequestMapping("addAdminController")
    public String doAdd(Model model,Admin admin){
        model.addAttribute("admin",this.adminServices.addAdmin(admin));
        return "redirect:/listAdminController";
    }
    @RequestMapping("deleteAdminController")
    public String delete(Model model,int adminId){
        model.addAttribute("admin",this.adminServices.deleteAdmin(adminId));
        return "redirect:/listAdminController";
    }
}
