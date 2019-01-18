package cn.tcmp068.aviation.clause.services.impl;

import cn.tcmp068.aviation.clause.dao.ClauseMapper;
import cn.tcmp068.aviation.clause.services.ClauseServices;
import cn.tcmp068.aviation.entity.Clause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ClauseServicesImpl implements ClauseServices {

    @Resource
    private ClauseMapper clauseMapper;

    @Override
    public int insert(Clause record) {

       int i= clauseMapper.insert(record);
        return i;
    }
}
