package cn.tcmp068.aviation.catalog.dao;


import cn.tcmp068.aviation.entity.Catalog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CatalogMapper {
    List<Catalog> queryAllCatalog(@Param("cataLaws") String cataLaws, int pageNumber, int pageSize);
    List<Catalog> queryByCateRank(int cateRank);//根据父级目录id获得其子目录
    int addCatalog(Catalog catalog);
    int deleteCatalog(int catalogId);
}