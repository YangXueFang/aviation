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
        model.addAttribute("clause",clauseServices.addClause(clause));
        return "clause";
    }

    @RequestMapping("queryAllClauseController")
    public String queryAllClause(Model model, Clause clause, @RequestParam(defaultValue = "1",required = false) int pageNumber, @RequestParam(defaultValue = "10",required = false) int pageSize){
        Clause c=new Clause();
        c.setClauseNumber(0);
        c.setClauseKeyword(" ");
        Laws la=new Laws();
        la.setLawsId("kong");
        c.setLawsId(la);
        if(clause.getClauseKeyword()!=null||clause.getClauseNumber()!=0||clause.getLawsId()!=null){
            if(clause.getClauseNumber()!=0){
                c.setClauseNumber(clause.getClauseNumber());
            }else{
                c.setClauseNumber(0);
            }
            if(clause.getClauseKeyword()!=" "){
                c.setClauseKeyword(clause.getClauseKeyword());
            }else{
                c.setClauseKeyword(" ");
            }
            if(clause.getLawsId()!=null){
                if(clause.getLawsId().getLawsId()!=" "&&clause.getLawsId().getLawsId()!="kong") {
                    la.setLawsId(clause.getLawsId().getLawsId());
                }
                c.setLawsId(la);
            }else{
                Laws laws=new Laws();
                laws.setLawsId("kong");
                c.setLawsId(laws);
            }
            model.addAttribute("clausePage", clauseServices.queryAllClause(clause, pageNumber, pageSize));
        }else {
            Clause cl=new Clause();
            model.addAttribute("clausePage", clauseServices.queryAllClause(cl, pageNumber, pageSize));
        }
        model.addAttribute("c",c);
        Laws laws=new Laws();
        model.addAttribute("laws",lawsService.queryAll(laws,1,100));
        return "clause";
    }

    public String delete(Model model,int clauseId){
        model.addAttribute("clause",this.clauseServices.deleteClause(clauseId));
        return null;
    }
    @RequestMapping("toUpdateClause")
    public String toUpdate(Model model,int clauseId){
        model.addAttribute("clause",this.clauseServices.detailClause(clauseId));
        return "updateClause";
    }

    public String doUpdate(Model model,Clause clause){
        model.addAttribute("clause",this.clauseServices.updateClause(clause));
        return null;
    }

}
