package cn.tcmp068.aviation.catalog.dao;


import cn.tcmp068.aviation.entity.Catalog;

public interface CatalogMapper {
    int deleteByPrimaryKey(Integer catalogid);

    int insert(Catalog record);

    int insertSelective(Catalog record);

    Catalog selectByPrimaryKey(Integer catalogid);

    int updateByPrimaryKeySelective(Catalog record);

    int updateByPrimaryKey(Catalog record);
}