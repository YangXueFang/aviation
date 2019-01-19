package cn.tcmp068.aviation.laws.controller;

import cn.tcmp068.aviation.entity.Laws;
import cn.tcmp068.aviation.laws.service.LawsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class LawsController {
    @Resource
    private LawsService lawsService;

    @RequestMapping("queryAllLawsController")
    public String queryAllLaws(Model model, Laws laws, @RequestParam(defaultValue = "1",required = false)int PageNumber, @RequestParam(defaultValue = "10",required = false)int PageSize){
        model.addAttribute("laws",this.lawsService.queryAll(laws,PageNumber,PageSize));

        return "lawsList";
    }
    @RequestMapping("toAddLawsController")
    public String toAdd(){
        return "addLaws";
    }
    @RequestMapping("doAddLawsController")
    public String doAdd(Model model, Laws laws){
        model.addAttribute("laws",this.lawsService.addLaws(laws));
        return "redirect:/queryAllLawsController";
    }
}
