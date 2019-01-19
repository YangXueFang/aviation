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



    public PageInfo<User> queryAll(User user, int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber,10);
        List<User> list=this.userMapper.queryAll(user,pageNumber,pageSize);
        PageInfo<User> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public User login(String userPhone, String userPassword) {

        return userMapper.login(userPhone,userPassword);
    }

    @Override
    public int insertUser(User user) {

        System.out.println(user.getUserPhone());
       User phone= userMapper.queryUserByPhone(user.getUserPhone());

       if(phone==null){
         return  userMapper.insertUser(user);
       }else {
           //用户已存在
           System.out.println("用户已存在,请重新输入！");
        return 0;
       }


    }

    @Override
    public int updateUser(String userPhone) {
        return userMapper.updateUser(userPhone);
    }

    @Override
    public User queryUserByPhone(String userPhone) {
        return userMapper.queryUserByPhone(userPhone);
    }


}
