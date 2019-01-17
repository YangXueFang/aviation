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
    public PageInfo<User> queryAll(User user, int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber,10);
        List<User> list=this.userMapper.queryAll(user,pageNumber,pageSize);
        PageInfo<User> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
