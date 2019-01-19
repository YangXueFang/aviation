package cn.tcmp068.aviation.user.controller;

import cn.tcmp068.aviation.entity.User;
import cn.tcmp068.aviation.user.services.UserServices;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserServices userServices;


//    @RequestMapping("listUserController")
//    public String queryAll(HttpServletResponse response, Model model, User user, @RequestParam(defaultValue = "1", required = false) int pageNumber, @RequestParam(defaultValue = "10", required = false) int pageSize) {
//        model.addAttribute("user", this.userServices.queryAll(user, pageNumber, pageSize));
//        return "user";
//    }

    @RequestMapping("listUserController")
    public String queryAll(Model model,@RequestParam(defaultValue = "1",required = false)String userPhone, @RequestParam(defaultValue = "1",required = false) int pageNumber, @RequestParam(defaultValue = "10",required = false) int pageSize){
        model.addAttribute("user",this.userServices.queryAll(userPhone,pageNumber,pageSize));
        model.addAttribute("phone",userPhone);
        return "user";
    }
}
