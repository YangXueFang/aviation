package cn.tcmp068.aviation.user.services.impl;

import cn.tcmp068.aviation.entity.User;
import cn.tcmp068.aviation.user.dao.UserMapper;
import cn.tcmp068.aviation.user.services.UserServices;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServicesImpl implements UserServices {

    @Resource
    private UserMapper userMapper;


    @Override
    public PageInfo<User> queryAll(String userPhone, int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<User> list=this.userMapper.queryAll(userPhone,pageNumber,pageSize);
        PageInfo<User> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
//
//    public PageInfo<User> queryAll(User user, int pageNumber, int pageSize) {
//        PageHelper.startPage(pageNumber,10);
//        List<User> list=this.userMapper.queryAll(user,pageNumber,pageSize);
//        PageInfo<User> pageInfo=new PageInfo<>(list);
//        return pageInfo;
//    }

    @Override
    public User login(String userPhone, String userPassword) {

        return userMapper.login(userPhone,userPassword);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
