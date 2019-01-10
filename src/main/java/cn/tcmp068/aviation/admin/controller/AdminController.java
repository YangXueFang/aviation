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


}
