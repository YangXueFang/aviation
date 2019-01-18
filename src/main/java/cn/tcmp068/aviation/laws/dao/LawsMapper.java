package cn.tcmp068.aviation.laws.dao;


import cn.tcmp068.aviation.entity.Laws;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LawsMapper {
    List<Laws> queryAll(@Param("laws") Laws laws, int pageNumber, int pageSize);//查所有
    int addLaws( Laws laws);//增加



}