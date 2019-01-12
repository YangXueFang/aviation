package cn.tcmp068.aviation.consult.services.impl;

import cn.tcmp068.aviation.consult.dao.ConsultMapper;
import cn.tcmp068.aviation.consult.services.ConsultServices;
import cn.tcmp068.aviation.entity.Admin;
import cn.tcmp068.aviation.entity.Consult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ConsultServicesImpl implements ConsultServices {
    @Resource
    private ConsultMapper consultMapper;


    @Override
    public PageInfo<Consult> queryAll(Consult consult, int pageNumber, int PageSize) {
        PageHelper.startPage(pageNumber,7);
        List<Consult> list = this.consultMapper.queryAll(consult, pageNumber, 7);
        PageInfo<Consult> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int deleteConsult(int consultId) {
        return this.consultMapper.deleteConsult(consultId);
    }
}
