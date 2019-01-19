package cn.tcmp068.aviation.clause.dao;

import cn.tcmp068.aviation.entity.Clause;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClauseMapper {


    int insert(Clause record);
    List<Clause> queryAllClause(@Param("clause") Clause clause);
    int deleteClause(int clauseId);

}