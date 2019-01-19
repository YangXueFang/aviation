package cn.tcmp068.aviation.user.dao;

import cn.tcmp068.aviation.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> queryAll(@Param("userPhone") String userPhone,int pageNumber,int pageSize);
    User login(@Param("userPhone")String userPhone,@Param("userPassword")String userPassword);
    int insertUser(User user);
    int updateUser(String userPhone);
    User queryUserByPhone(@Param("userPhone")String userPhone);

}
