package cn.tcmp068.aviation.admin.dao;

import cn.tcmp068.aviation.entity.Admin;

import java.util.List;

public interface AdminMapper {

    List<Admin> queryAll();
    int addAdmin(Admin admin);
    int deleteAdmin(int adminId);

}
