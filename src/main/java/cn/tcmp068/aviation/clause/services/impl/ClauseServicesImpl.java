package cn.tcmp068.aviation.clause.services.impl;

import cn.tcmp068.aviation.clause.dao.ClauseMapper;
import cn.tcmp068.aviation.clause.services.ClauseServices;
import cn.tcmp068.aviation.entity.Clause;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClauseServicesImpl implements ClauseServices {

    @Resource
    private ClauseMapper clauseMapper;

    @Override
    public int insert(Clause record) {

       int i= clauseMapper.insert(record);
        return i;
    }

    @Override
    public PageInfo<Clause> queryAllClause(Clause clause, int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<Clause> list=this.clauseMapper.queryAllClause(clause);
        PageInfo<Clause> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int deleteClause(int clauseId) {
        return this.clauseMapper.deleteClause(clauseId);
    }
}