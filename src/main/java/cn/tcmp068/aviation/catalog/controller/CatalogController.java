package cn.tcmp068.aviation.catalog.controller;

import cn.tcmp068.aviation.catalog.services.CatalogServices;
import cn.tcmp068.aviation.entity.Catalog;
import cn.tcmp068.aviation.entity.Laws;
import cn.tcmp068.aviation.tools.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONArray;
import net.sf.json.util.JSONUtils;
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
    @RequestMapping("cataLogDeleteController")
    public String delete(Model model,int catalogId){
        model.addAttribute("cataLog",this.catalogServices.deleteCatalog(catalogId));
        return "redirect:/cataLogListController";
    }
    @RequestMapping("cataLogListController")
    public String queryAllCataLog(Model model,Laws laws,@RequestParam(defaultValue = "0")String cataLaws,@RequestParam(defaultValue = "1", required = false) int pageNumber, @RequestParam(defaultValue = "10", required = false) int pageSize){
        List<Catalog> alist=null;
        if(cataLaws.equals("0")) {
            alist = catalogServices.queryAllCatalog(catalogServices.queryOneCataLaws().getCataLaws(), pageNumber, pageSize).getList();
        }else{
            alist = catalogServices.queryAllCatalog(cataLaws, pageNumber, pageSize).getList();
        }
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
        PageHelper.startPage(pageNumber,pageSize);
        PageInfo<Catalog> pageInfo=new PageInfo<>(list);
        PageUtil<Catalog> pageUtil = new PageUtil<Catalog>(list, 10,pageNumber);
        List<Catalog> sublist = pageUtil.getObjects(pageNumber);
          for(int i = 0; i < sublist.size(); i++) {
           System.out.println("=============="+sublist.get(i));
        }
        model.addAttribute("catalog",pageUtil);
        System.out.println("==================="+pageUtil.getPage());
        System.out.println("==================="+this.catalogServices.queryAll(laws,pageNumber,pageSize));
       model.addAttribute("llist",this.catalogServices.queryAll(laws,pageNumber,pageSize));
        return "lawsCatalog";
    }
        @RequestMapping("listController")
        @ResponseBody
        public Object list(@RequestParam(defaultValue = "CARE-23-R1")String cataLaws, int pageNumber,  int pageSize){
            List<Catalog> alist=catalogServices.queryAllCatalog(cataLaws, pageNumber, pageSize).getList();
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
            PageHelper.startPage(pageNumber,pageSize);
            PageInfo<Catalog> pageInfo=new PageInfo<>(list);
            System.out.println("==============="+pageInfo.getPageSize());
            System.out.println("-----------------"+pageInfo.getPageNum());
            return pageInfo.getList();
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
        @RequestMapping("toUpdate")
        public String toUpdate(Model model,int catalogId,String cataLaws,Laws laws,@RequestParam(defaultValue = "1", required = false) int pageNumber, @RequestParam(defaultValue = "10", required = false) int pageSize){
            Catalog catalog=this.catalogServices.queryBycatalogId(catalogId);
            model.addAttribute("catalog",catalog);

            model.addAttribute("llist",this.catalogServices.queryAll(laws,pageNumber,pageSize));

            String cl=catalog.getCataLaws();
            System.out.println(cl);
            List<Catalog> alist = this.catalogServices.queryAllCatalog(cl, pageNumber, pageSize).getList();
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
            model.addAttribute("list",list);
            System.out.println(list);
        return "updateCatalog";
        }
    @RequestMapping("doUpdate")
        public String doUpdate(Model model,Catalog catalog){
        model.addAttribute("catalog",this.catalogServices.updateCatalog(catalog));
        return "redirect:/cataLogListController";
        }
}
