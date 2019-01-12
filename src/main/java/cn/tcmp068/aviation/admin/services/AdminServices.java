package cn.tcmp068.aviation.admin.services;

import cn.tcmp068.aviation.entity.Admin;

import java.util.List;

public interface AdminServices {

    List<Admin> queryAll();
    int addAdmin(Admin admin);
    int deleteAdmin(int adminId);
}
