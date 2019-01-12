package cn.tcmp068.aviation.consult.dao;

import cn.tcmp068.aviation.entity.Consult;

public interface ConsultMapper {
    int deleteByPrimaryKey(Integer consultid);

    int insert(Consult record);

    int insertSelective(Consult record);

    Consult selectByPrimaryKey(Integer consultid);

    int updateByPrimaryKeySelective(Consult record);

    int updateByPrimaryKey(Consult record);
}