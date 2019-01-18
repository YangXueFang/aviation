package cn.tcmp068.aviation.leave.dao;


import cn.tcmp068.aviation.entity.Leave;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LeaveMapper {
    List<Leave> queryAll(int pageNumber,int pageSize);
    Leave queryByleaveId(int leaveId);
    int deleteLeave(int leaveId);
    int addLeave( Leave leave);//增加
}