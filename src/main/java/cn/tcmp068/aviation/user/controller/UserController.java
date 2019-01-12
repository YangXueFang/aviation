package cn.tcmp068.aviation.user.controller;

import cn.tcmp068.aviation.entity.User;
import cn.tcmp068.aviation.user.services.UserServices;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource
    private UserServices userServices;

    @RequestMapping("user")
    public String user(){
        return "user";
    }
    @RequestMapping("listUserController")
    public String queryAll(Model model, User user, @RequestParam(defaultValue = "1",required = false) int pageNumber, @RequestParam(defaultValue = "7",required = false) int pageSize){
        model.addAttribute("user",this.userServices.queryAll(user,pageNumber,pageSize));
        PageInfo<User> pageInfo = this.userServices.queryAll(user, pageNumber, pageSize);
        for(User u:pageInfo.getList()){
            System.out.print(u);
        }
        return "user";
    }
}
