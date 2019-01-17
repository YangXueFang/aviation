package cn.tcmp068.aviation.catalog.controller;

import cn.tcmp068.aviation.catalog.services.CatalogServices;
import cn.tcmp068.aviation.entity.Catalog;
import cn.tcmp068.aviation.entity.Laws;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class CatalogController {
    @Resource
    private CatalogServices catalogServices;

    @RequestMapping("cataLogListController")
    public String queryAll(Model model, Laws laws,@RequestParam(defaultValue = "1", required = false) int pageNumber, @RequestParam(defaultValue = "10", required = false) int pageSize, String cataLaws){
        model.addAttribute("cataLog",this.catalogServices.queryAll(cataLaws,pageNumber,pageSize));
        model.addAttribute("llist",this.catalogServices.queryAll(laws,pageNumber,pageSize));
        return "lawsCatalog";
    }

    @RequestMapping("cataLogAddController")
    public String toAdd(){
        return "addCatalog";
    }
    @RequestMapping("cataLogDoAddController")
    public String doAdd(Model model, Catalog catalog){
        model.addAttribute("cataLog",this.catalogServices.addCatalog(catalog));
        return null;
    }
    public String delete(Model model,int cataLogId){
        model.addAttribute("cataLog",this.catalogServices.deleteCatalog(cataLogId));
        return null;
    }
}
