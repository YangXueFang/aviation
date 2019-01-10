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



}
