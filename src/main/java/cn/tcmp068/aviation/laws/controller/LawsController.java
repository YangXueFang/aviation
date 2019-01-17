package cn.tcmp068.aviation.laws.controller;

import cn.tcmp068.aviation.laws.service.LawsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class LawsController {
    @Resource
    private LawsService lawsService;

    @RequestMapping("queryAllLaws")
    public String queryAllLaws(Model model){
        return "";
    }
}
