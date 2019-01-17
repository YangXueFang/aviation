package cn.tcmp068.aviation.consult.dao;

import cn.tcmp068.aviation.entity.Admin;
import cn.tcmp068.aviation.entity.Consult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConsultMapper {

    List<Consult> queryAll(@Param("consult")Consult consult,int pageNumber,int PageSize);
    int deleteConsult(int consultId);
    List<Consult> queryAllByuserId(int userId);//历史咨询
    Consult queryConsultByuserId(@Param("consultId") int consultId,int userId);//查看详情
    int addConsult(@Param("consult") Consult consult,int userId);//增加

}
