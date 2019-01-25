package cn.tcmp068.aviation.clause.dao;

import cn.tcmp068.aviation.entity.Clause;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClauseMapper {


    int addClause(Clause clause);
    List<Clause> queryAllClause(@Param("clause") Clause clause);
    int deleteClause(int clauseId);
    Clause detailClause(int clauseId);
    int updateClause(@Param("clause") Clause clause);
    List<Clause> queryByCatalogId(int catalogId);//查询同一目录下的所有条款
}