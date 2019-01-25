package cn.tcmp068.aviation.catalog.dao;


import cn.tcmp068.aviation.entity.Catalog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CatalogMapper {
    List<Catalog> queryAllCatalog(@Param("cataLaws") String cataLaws);
    List<Catalog> queryByCateRank(int cateRank);//根据父级目录id获得其子目录
    int addCatalog(Catalog catalog);
    int deleteCatalog(int catalogId);
    Catalog queryBycatalogId(int catalogId);
    int updateCatalog(Catalog catalog);
    Catalog queryOneCataLaws();//查询第一个

}