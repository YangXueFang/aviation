package cn.tcmp068.aviation.catalog.dao;


import cn.tcmp068.aviation.entity.Catalog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CatalogMapper {
    List<Catalog> queryAll(@Param("cataLaws") String cataLaws, int pageNumber, int pageSize);
    int addCatalog(Catalog catalog);
    int deleteCatalog(int catalogId);
}