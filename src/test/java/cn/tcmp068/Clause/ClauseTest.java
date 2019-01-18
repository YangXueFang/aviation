package cn.tcmp068.Clause;


import cn.tcmp068.aviation.clause.dao.ClauseMapper;
import cn.tcmp068.aviation.clause.services.ClauseServices;
import cn.tcmp068.aviation.entity.Catalog;
import cn.tcmp068.aviation.entity.Clause;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClauseTest {

    @Autowired
    private ClauseServices clauseServices;

    @Test
    public void testInsert(){
        System.out.println(clauseServices);

//        Catalog catalog=new Catalog();
//        catalog.setCatalogId(1);
//        catalog.setCataLaws(1);
//        catalog.setCateGrade(2);
//        catalog.setCateNumber(1);
//        catalog.setCateRank(3);
//        catalog.setCateText("asd");

       Clause clause=new Clause();
       clause.setCateLogid(1);

        clause.setLawsid(1);
        clause.setClausenumber(1);
        clause.setClausename("qwe");
        clause.setClauseversions(213);
        clause.setClausetitle("zxc");
        clause.setClausetext("asdasdad");

        clauseServices.insert(clause);
    }
}
