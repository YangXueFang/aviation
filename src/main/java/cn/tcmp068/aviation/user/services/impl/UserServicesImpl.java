package cn.tcmp068.aviation.user.services.impl;

import cn.tcmp068.aviation.entity.User;
import cn.tcmp068.aviation.user.dao.UserMapper;
import cn.tcmp068.aviation.user.services.UserServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServicesImpl implements UserServices {

    @Resource
    private UserMapper userMapper;
}
