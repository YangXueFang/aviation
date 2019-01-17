package cn.tcmp068.aviation.consult.services;

import cn.tcmp068.aviation.entity.Admin;
import cn.tcmp068.aviation.entity.Consult;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConsultServices {

    PageInfo<Consult> queryAll(Consult consult, int pageNumber, int PageSize);
    int deleteConsult(int consultId);
    List<Consult> queryAllByuserId(int userId);//历史咨询
    Consult queryConsultByuserId(int consultId);//查看详情
    int addConsult( Consult consult);//增加
}
