package cn.tcmp068.aviation.laws.controller;

import cn.tcmp068.aviation.catalog.services.CatalogServices;
import cn.tcmp068.aviation.clause.services.ClauseServices;
import cn.tcmp068.aviation.entity.Catalog;
import cn.tcmp068.aviation.entity.Clause;
import cn.tcmp068.aviation.entity.Laws;
import cn.tcmp068.aviation.laws.service.LawsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LawsController {
    @Resource
    private LawsService lawsService;
    @Resource
    private CatalogServices catalogServices;

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

    @RequestMapping("toUpdateLawsController")
    public String toUpdate(Model model,String lawsId){
        model.addAttribute("Laws",this.lawsService.queryLawsById(lawsId));
        return "updateLaws";
    }
    @RequestMapping("doUpdateLawsController")
    public String doUpdate(Model model,Laws laws){
        model.addAttribute("Laws",this.lawsService.updateLaws(laws));
        return "redirect:/queryAllLawsController";
    }
    @RequestMapping("deleteLawsController")
    public String delete(String lawsId,Model model) {
        model.addAttribute("Laws",this.lawsService.deleteLawsById(lawsId));
        return "redirect:/queryAllLawsController";
    }


    /////////////////////////手机端
    @RequestMapping("queryAllLawsPhoneController")
    public String queryAll(Model model, Laws laws, @RequestParam(defaultValue = "1",required = false)int PageNumber, @RequestParam(defaultValue = "10",required = false)int PageSize){
        model.addAttribute("laws",this.lawsService.queryAll(laws,PageNumber,PageSize));
        return "about";
    }
    @RequestMapping("detailLaws")
    public String detailLaws(Model model,String lawsId){
        List<Catalog> alist = this.catalogServices.queryAllCatalog(lawsId);
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
        model.addAttribute("lawsList",list);
        model.addAttribute("laws",lawsService.queryLawsById(lawsId));
        return "detailLaws";
    }

}
