package cn.tcmp068.aviation.clause.dao;

import cn.tcmp068.aviation.entity.Clause;

public interface ClauseMapper {
    int deleteByPrimaryKey(Integer clauseid);

    int insert(Clause record);

    int insertSelective(Clause record);

    Clause selectByPrimaryKey(Integer clauseid);

    int updateByPrimaryKeySelective(Clause record);

    int updateByPrimaryKey(Clause record);
}