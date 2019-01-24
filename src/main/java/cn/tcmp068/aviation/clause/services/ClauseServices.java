package cn.tcmp068.aviation.clause.services;

import cn.tcmp068.aviation.entity.Clause;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClauseServices {
    int addClause(Clause clause);
    PageInfo<Clause> queryAllClause(Clause clause,int pageNumber,int pageSize);
    int deleteClause(int clauseId);
    Clause detailClause(int clauseId);
    int updateClause(Clause clause);
}
