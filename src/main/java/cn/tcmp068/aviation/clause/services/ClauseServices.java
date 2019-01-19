package cn.tcmp068.aviation.clause.services;

import cn.tcmp068.aviation.entity.Clause;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ClauseServices {
    int insert(Clause record);
    PageInfo<Clause> queryAllClause(Clause clause,int pageNumber,int pageSize);
    int deleteClause(int clauseId);
}
