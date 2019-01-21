package cn.tcmp068.aviation.leave.controller;

import cn.tcmp068.aviation.entity.Leave;
import cn.tcmp068.aviation.leave.services.LeaveServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class LeaveController {
    @Resource
    private LeaveServices leaveServices;

    @RequestMapping("/qwe")
    @ResponseBody
    public String xx(){
        return "xxxxxxxxxx";
    }


    @RequestMapping("listLeaveController")
    public String queryAll(Model model, @RequestParam(defaultValue = "1",required = false) int pageNumber,  @RequestParam(defaultValue = "10",required = false)int pageSize){
        model.addAttribute("leave",this.leaveServices.queryAll(pageNumber,pageSize));
        return "leave";
    }
    @RequestMapping("detailLeaveController")
    public String detail(Model model,int leaveId){
        model.addAttribute("leave",this.leaveServices.queryByleaveId(leaveId));
       return  null;
    }
    @RequestMapping("deleteLeaveController")
    public String delete(Model model,int leaveId){
        model.addAttribute("leave",this.leaveServices.deleteLeave(leaveId));
        return  null;
    }
    @RequestMapping("toAddLeaveController")
    public String toAdd(){
        return null;
    }
    @RequestMapping("doAddLeaveController")
    public String doAdd(Model model,Leave leave){
        model.addAttribute("leave",this.leaveServices.addLeave(leave));
        return null;
    }
}
