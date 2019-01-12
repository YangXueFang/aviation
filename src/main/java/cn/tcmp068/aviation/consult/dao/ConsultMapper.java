package cn.tcmp068.aviation.consult.dao;

import cn.tcmp068.aviation.entity.Admin;
import cn.tcmp068.aviation.entity.Consult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConsultMapper {

    List<Consult> queryAll(@Param("consult")Consult consult,int pageNumber,int PageSize);
    int deleteConsult(int consultId);

}
