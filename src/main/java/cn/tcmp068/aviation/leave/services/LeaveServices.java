package cn.tcmp068.aviation.leave.services;

import cn.tcmp068.aviation.entity.Leave;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface LeaveServices {

    PageInfo<Leave> queryAll(int pageNumber, int pageSize);
    Leave queryByleaveId(int leaveId);
    int deleteLeave(int leaveId);
    int addLeave(Leave leave);
}
