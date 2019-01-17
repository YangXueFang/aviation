package cn.tcmp068.aviation.leave.services.impl;

import cn.tcmp068.aviation.entity.Leave;
import cn.tcmp068.aviation.leave.dao.LeaveMapper;
import cn.tcmp068.aviation.leave.services.LeaveServices;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LeaveServicesImpl implements LeaveServices {
    @Resource
    private LeaveMapper leaveMapper;
    @Override
    public PageInfo<Leave> queryAll(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<Leave> list = this.leaveMapper.queryAll(pageNumber, pageSize);
        PageInfo<Leave> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Leave queryByleaveId(int leaveId) {
        return this.leaveMapper.queryByleaveId(leaveId);
    }

    @Override
    public int deleteLeave(int leaveId) {
        return this.leaveMapper.deleteLeave(leaveId);
    }

    @Override
    public int addLeave(Leave leave, int userId) {
        return this.leaveMapper.addLeave(leave,userId);
    }
}
