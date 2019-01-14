package cn.tcmp068.aviation.consult.dao;

<<<<<<< HEAD
import cn.tcmp068.aviation.entity.Admin;
import cn.tcmp068.aviation.entity.Consult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConsultMapper {

    List<Consult> queryAll(@Param("consult")Consult consult,int pageNumber,int PageSize);
    int deleteConsult(int consultId);

}
=======
import cn.tcmp068.aviation.entity.Consult;

public interface ConsultMapper {
    int deleteByPrimaryKey(Integer consultid);

    int insert(Consult record);

    int insertSelective(Consult record);

    Consult selectByPrimaryKey(Integer consultid);

    int updateByPrimaryKeySelective(Consult record);

    int updateByPrimaryKey(Consult record);
}
>>>>>>> d89664ec0aa157a654e21bb1830ebd251e3afad4
