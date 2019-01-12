package cn.tcmp068.aviation.laws.dao;


import cn.tcmp068.aviation.entity.Laws;

public interface LawsMapper {
    int deleteByPrimaryKey(Integer lawsid);

    int insert(Laws record);

    int insertSelective(Laws record);

    Laws selectByPrimaryKey(Integer lawsid);

    int updateByPrimaryKeySelective(Laws record);

    int updateByPrimaryKey(Laws record);
}