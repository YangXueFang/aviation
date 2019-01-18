package cn.tcmp068.aviation.clause.controller;

import cn.tcmp068.aviation.clause.services.ClauseServices;
import cn.tcmp068.aviation.entity.Clause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class ClauserController {
    @Autowired
    private ClauseServices clauseServices;

    @RequestMapping("toAdd")
    public String toAdd(){
        return "addClause";
    }

    @RequestMapping("doAdd")
    public String doAdd(Map map,Clause clause){
        map.put("qwe",clauseServices.insert(clause));
        return "clause";
    }




}
