package cn.tcmp068.aviation.laws.service.impl;

import cn.tcmp068.aviation.entity.Laws;
import cn.tcmp068.aviation.laws.dao.LawsMapper;
import cn.tcmp068.aviation.laws.service.LawsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LawsServiceImpl implements LawsService {
    @Resource
    private LawsMapper lawsMapper;

    public PageInfo<Laws> queryAll(Laws laws, int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        PageInfo<Laws> page=new PageInfo<>();
        page.setTotal(page.getTotal());
        List<Laws> list=this.lawsMapper.queryAll(laws,pageNumber,5);
        PageInfo<Laws> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }


    public int addLaws(Laws laws) {
        return this.lawsMapper.addLaws(laws);
    }
}
