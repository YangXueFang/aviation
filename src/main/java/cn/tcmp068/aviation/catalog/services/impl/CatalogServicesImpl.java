package cn.tcmp068.aviation.catalog.services.impl;

import cn.tcmp068.aviation.catalog.dao.CatalogMapper;
import cn.tcmp068.aviation.catalog.services.CatalogServices;
import cn.tcmp068.aviation.entity.Catalog;
import cn.tcmp068.aviation.entity.Laws;
import cn.tcmp068.aviation.laws.dao.LawsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

@Service
public class CatalogServicesImpl implements CatalogServices {
    @Resource
    private CatalogMapper catalogMapper;
    @Resource
    private LawsMapper lawsMapper;


    @Override
    public int addCatalog(Catalog catalog) {
        return this.catalogMapper.addCatalog(catalog);
    }

    @Override
    public int deleteCatalog(int catalogId) {
        return this.deleteCatalog(catalogId);
    }

    @Override
    public PageInfo<Catalog> queryAllCatalog(String cataLaws, int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<Catalog> clist = catalogMapper.queryAllCatalog(cataLaws,pageNumber,pageSize);
        PageInfo<Catalog> pageInfo=new PageInfo<>(clist);
        return pageInfo;
    }


    @Override
    public List<Catalog> queryByCateRank(int cateRank) {
        return catalogMapper.queryByCateRank(cateRank);
    }

    @Override
    public PageInfo<Laws> queryAll(Laws laws, int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<Laws> list=this.lawsMapper.queryAll(laws,pageNumber,5);
        PageInfo<Laws> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
