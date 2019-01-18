package cn.tcmp068.aviation.catalog.services;

import cn.tcmp068.aviation.entity.Catalog;
import cn.tcmp068.aviation.entity.Laws;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CatalogServices {
    PageInfo<Catalog> queryAll(@Param("cataLaws") String cataLaws, int pageNumber, int pageSize);
    int addCatalog(Catalog catalog);
    int deleteCatalog(int catalogId);
    PageInfo<Laws> queryAll(Laws laws, int pageNumber, int pageSize);//查所有
}
