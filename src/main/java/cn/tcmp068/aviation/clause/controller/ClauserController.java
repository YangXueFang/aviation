package cn.tcmp068.aviation.clause.controller;

import cn.tcmp068.aviation.catalog.services.CatalogServices;
import cn.tcmp068.aviation.clause.services.ClauseServices;
import cn.tcmp068.aviation.entity.Catalog;
import cn.tcmp068.aviation.entity.Clause;
import cn.tcmp068.aviation.entity.Laws;
import cn.tcmp068.aviation.laws.service.LawsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ClauserController {
    @Autowired
    private ClauseServices clauseServices;
    @Resource
    private CatalogServices catalogServices;
    @Resource
    private LawsService lawsService;
    @RequestMapping("toAdd")
    public String toAdd(Model model,Laws laws,@RequestParam(defaultValue = "1",required = false) int pageNumber,@RequestParam(defaultValue = "10",required = false)int pageSize){
        model.addAttribute("llist",this.lawsService.queryAll(laws,pageNumber,pageSize));
        System.out.println(this.lawsService.queryAll(laws,pageNumber,pageSize)+"=============================");
        return "addClause";
    }

    @RequestMapping("doAddClauseController")
    public String doAdd(Model model,Clause clause){
        model.addAttribute("clause",this.clauseServices.addClause(clause));
        return "redirect:/queryAllClauseController";
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

    @RequestMapping("ajaxClause")
    @ResponseBody
    public List<Catalog> ajax(Model model, String cataLaws, @RequestParam(defaultValue = "1", required = false) int pageNumber, @RequestParam(defaultValue = "10", required = false) int pageSize){
        List<Catalog> alist = this.catalogServices.queryAllCatalog(cataLaws, pageNumber, pageSize).getList();
        List<Catalog> list = new ArrayList<>();
        if(alist!=null) {
            for (int a = 0; a < alist.size(); a++) {
                list.add(alist.get(a));
                List<Catalog> blist = catalogServices.queryByCateRank(alist.get(a).getCatalogId());
                for (int b = 0; b < blist.size(); b++) {
                    list.add(blist.get(b));
                    List<Catalog> clist = catalogServices.queryByCateRank(blist.get(b).getCatalogId());
                    for (int c = 0; c < clist.size(); c++) {
                        list.add(clist.get(c));
                    }
                    clist.clear();
                }
                blist.clear();
            }
        }
        System.out.println(list);
        return list;
    }

}
