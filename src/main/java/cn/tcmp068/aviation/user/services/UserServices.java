package cn.tcmp068.aviation.user.services;

import cn.tcmp068.aviation.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserServices {
    PageInfo<User> queryAll(String userPhone,int pageNumber,int pageSize);

    User login(String userPhone,String userPassword);
    int insertUser(User user);
    int updateUser(User user);
}
