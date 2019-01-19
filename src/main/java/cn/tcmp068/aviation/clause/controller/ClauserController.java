package cn.tcmp068.aviation.clause.controller;

import cn.tcmp068.aviation.clause.services.ClauseServices;
import cn.tcmp068.aviation.entity.Clause;
import cn.tcmp068.aviation.entity.Laws;
import cn.tcmp068.aviation.laws.service.LawsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class ClauserController {
    @Autowired
    private ClauseServices clauseServices;
    @Resource
    private LawsService lawsService;
    @RequestMapping("toAdd")
    public String toAdd(Model model,Laws laws,@RequestParam(defaultValue = "1",required = false) int pageNumber,@RequestParam(defaultValue = "10",required = false)int pageSize){
        model.addAttribute("llist",this.lawsService.queryAll(laws,pageNumber,pageSize));
        System.out.println(this.lawsService.queryAll(laws,pageNumber,pageSize)+"=============================");
        return "addClause";
    }

    @RequestMapping("doAdd")
    public String doAdd(Model model,Clause clause){
        model.addAttribute("clause",clauseServices.insert(clause));

        return "clause";
    }

    @RequestMapping("queryAllClauseController")
    public String queryAllClause(Model model, Clause clause, @RequestParam(defaultValue = "0",required = false) int clauseNumber, @RequestParam(defaultValue = " ",required = false)String clauseKeyword, @RequestParam(defaultValue = " ",required = false)String lawsId, @RequestParam(defaultValue = "1",required = false) int pageNumber, @RequestParam(defaultValue = "10",required = false) int pageSize){
        Clause c=new Clause();

        c.setClauseNumber(clauseNumber);

        if(clauseKeyword!=" ") {
            c.setClauseKeyword(clauseKeyword);
        }
        if(lawsId != " "){
            Laws laws=new Laws();
            laws.setLawsId(lawsId);
            c.setLawsId(laws);
        }
        if(clause != null){
            model.addAttribute("clausePage",clauseServices.queryAllClause(clause,pageNumber,pageSize));
            System.out.println(clause+"=>clause");
            System.out.println("=======================>1");
        }else {
            model.addAttribute("clausePage", clauseServices.queryAllClause(c, pageNumber, pageSize));
            System.out.println("=======================>2");
        }
        return "clause";
    }

    public String delete(Model model,int clauseId){
        model.addAttribute("clause",this.clauseServices.deleteClause(clauseId));
        return null;
    }



}
