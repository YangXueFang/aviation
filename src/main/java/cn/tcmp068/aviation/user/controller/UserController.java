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

    @RequestMapping("web")
    public String web(){
        return "web";
    }
    @RequestMapping("smpt")
    public String smpt(){
        return "smpt";
    }
    @RequestMapping("message")
    public String message(){
        return "message";
    }
    @RequestMapping("indexPhone")
    public String indexPhone(){
        return "indexPhone";
    }
    @RequestMapping("about")
    public String about(){
        return "about";
    }
    @RequestMapping("my")
    public String my(){
        return "my";
    }
    @RequestMapping("collection")
    public String collection(){
        return "collection";
    }
    @RequestMapping("updatePhone")
    public String updatePhone(){
        return "updatePhone";
    }
    @RequestMapping("updatePassword")
    public String updatePassword(){
        return "updatePassword";
    }
    @RequestMapping("loginUser")
    public String loginUser(){
        return "loginUser";
    }
    @RequestMapping("addUser")
    public String addUser(){
        return "addUser";
    }
    @RequestMapping("forgetPassword")
    public String forgetPassword(){
        return "forgetPassword";
    }
    @RequestMapping("detailLaws")
    public String detailLaws(){
        return "detailLaws";
    }
    @RequestMapping("detailCatalog")
    public String detailCatalog(){
        return "detailCatalog";
    }


    @RequestMapping("listUserController")
    public String queryAll(Model model,@RequestParam(defaultValue = "1",required = false)String userPhone, @RequestParam(defaultValue = "1",required = false) int pageNumber, @RequestParam(defaultValue = "10",required = false) int pageSize){
       System.out.println("===============>"+this.userServices.queryAll(userPhone,pageNumber,pageSize));
        model.addAttribute("user",this.userServices.queryAll(userPhone,pageNumber,pageSize));
        model.addAttribute("phone",userPhone);
        return "user";
    }
}
