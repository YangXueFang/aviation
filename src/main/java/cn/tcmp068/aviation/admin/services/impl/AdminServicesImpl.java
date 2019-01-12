package cn.tcmp068.aviation.admin.services.impl;

import cn.tcmp068.aviation.admin.dao.AdminMapper;
import cn.tcmp068.aviation.admin.services.AdminServices;
import cn.tcmp068.aviation.entity.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServicesImpl implements AdminServices{
    @Resource
    private AdminMapper adminMapper;


    @Override
    public List<Admin> queryAll() {
        return this.adminMapper.queryAll();
    }

    @Override
    public int addAdmin(Admin admin) {
        return this.adminMapper.addAdmin(admin);
    }

    @Override
    public int deleteAdmin(int adminId) {
        return this.adminMapper.deleteAdmin(adminId);
    }
}
