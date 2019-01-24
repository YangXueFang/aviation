package cn.tcmp068.aviation.catalog.services;

import cn.tcmp068.aviation.entity.Catalog;
import cn.tcmp068.aviation.entity.Laws;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CatalogServices {
    int addCatalog(Catalog catalog);
    int deleteCatalog(int catalogId);
    PageInfo<Catalog> queryAllCatalog(String cataLaws,int pageNumber, int pageSize);
    List<Catalog> queryByCateRank(int cateRank);//根据父级目录id获得其子目录
    PageInfo<Laws> queryAll(Laws laws, int pageNumber, int pageSize);//查所有
    Catalog queryBycatalogId(int catalogId);
    int updateCatalog(Catalog catalog);
    Catalog queryOneCataLaws();//查询第一个
}
