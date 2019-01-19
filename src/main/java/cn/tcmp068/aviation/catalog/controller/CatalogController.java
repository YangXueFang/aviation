package cn.tcmp068.aviation.catalog.controller;

import cn.tcmp068.aviation.catalog.services.CatalogServices;
import cn.tcmp068.aviation.entity.Catalog;
import cn.tcmp068.aviation.entity.Laws;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CatalogController {
    @Resource
    private CatalogServices catalogServices;

    @RequestMapping("cataLogAddController")
    public String toAdd(Model model, Laws laws,@RequestParam(defaultValue = "1", required = false) int pageNumber, @RequestParam(defaultValue = "10", required = false) int pageSize){
        model.addAttribute("llist",this.catalogServices.queryAll(laws,pageNumber,pageSize));
        return "addCatalog";
    }
    @RequestMapping("cataLogDoAddController")
    public String doAdd(Model model, Catalog catalog){
        model.addAttribute("cataLog",this.catalogServices.addCatalog(catalog));
        return "redirect:/cataLogListController";
    }
    public String delete(Model model,int cataLogId){
        model.addAttribute("cataLog",this.catalogServices.deleteCatalog(cataLogId));
        return null;
    }
    @RequestMapping("cataLogListController")
    public String queryAllCataLog(Model model,Laws laws,String cataLaws,@RequestParam(defaultValue = "1", required = false) int pageNumber, @RequestParam(defaultValue = "10", required = false) int pageSize){
        List<Catalog> alist = catalogServices.queryAllCatalog(cataLaws,pageNumber,pageSize).getList();
        List<Catalog> list=new ArrayList<>();
        for(int a=0;a<alist.size();a++){
            list.add(alist.get(a));
            List<Catalog> blist = catalogServices.queryByCateRank(alist.get(a).getCatalogId());
            for(int b=0;b<blist.size();b++){
                list.add(blist.get(b));
                List<Catalog> clist = catalogServices.queryByCateRank(blist.get(b).getCatalogId());
                for(int c=0;c<clist.size();c++){
                    list.add(clist.get(c));
                }
                clist.clear();
            }
            blist.clear();
        }
       // PageInfo<Catalog> pageInfo=new PageInfo<>(list);
        model.addAttribute("list",list);
        model.addAttribute("llist",this.catalogServices.queryAll(laws,pageNumber,pageSize));
        return "lawsCatalog";
    }

        @RequestMapping("ajax")
        @ResponseBody
        public List<Catalog> ajax(Model model,String cataLaws,@RequestParam(defaultValue = "1", required = false) int pageNumber, @RequestParam(defaultValue = "10", required = false) int pageSize){
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
