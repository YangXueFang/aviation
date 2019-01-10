package cn.tcmp068.aviation.user.controller;

import cn.tcmp068.aviation.entity.User;
import cn.tcmp068.aviation.user.services.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource
    private UserServices userServices;


}
