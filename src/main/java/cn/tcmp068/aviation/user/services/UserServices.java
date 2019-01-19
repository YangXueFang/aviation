package cn.tcmp068.aviation.user.services;

import cn.tcmp068.aviation.entity.User;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserServices {
    PageInfo<User> queryAll(User user, int pageNumber, int pageSize);

    User login(String userPhone,String userPassword);
    int insertUser(User user);
    int updateUser(String userPhone);
    User queryUserByPhone(String userPhone);
}
