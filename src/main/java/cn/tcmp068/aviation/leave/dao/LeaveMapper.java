package cn.tcmp068.aviation.leave.dao;


import cn.tcmp068.aviation.entity.Leave;

public interface LeaveMapper {
    int deleteByPrimaryKey(Integer leaveid);

    int insert(Leave record);

    int insertSelective(Leave record);

    Leave selectByPrimaryKey(Integer leaveid);

    int updateByPrimaryKeySelective(Leave record);

    int updateByPrimaryKey(Leave record);
}