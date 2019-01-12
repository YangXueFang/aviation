package cn.tcmp068.aviation.user.services;

import cn.tcmp068.aviation.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserServices {
    PageInfo<User> queryAll(User user, int pageNumber, int pageSize);
}
