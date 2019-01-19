package cn.tcmp068.aviation;

import cn.tcmp068.aviation.clause.services.ClauseServices;
import cn.tcmp068.aviation.entity.Clause;
import cn.tcmp068.aviation.entity.User;
import cn.tcmp068.aviation.admin.dao.AdminMapper;
import cn.tcmp068.aviation.consult.dao.ConsultMapper;
import cn.tcmp068.aviation.entity.*;
import cn.tcmp068.aviation.laws.dao.LawsMapper;
import cn.tcmp068.aviation.laws.service.LawsService;
import cn.tcmp068.aviation.leave.dao.LeaveMapper;
import cn.tcmp068.aviation.user.dao.UserMapper;
import cn.tcmp068.aviation.user.services.UserServices;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.springframework.util.DigestUtils;
import sun.plugin2.message.Message;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AviationApplicationTests {



    @Resource
    private UserMapper userMapper;
    @Resource
    private UserServices userServices;

    @Test
    public void testLogin(){
        System.out.println(userMapper.login("14315468523","123456"));
    }

    @Test
    public void testAddUser(){
        User u=new User();
//        String password="123123";
//        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());

        u.setUserPassword("1231245124");
        u.setUserPhone("15233151983");
        u.setUserStatus(1);
        u.setUserType(1);
        userServices.insertUser(u);
    }

    public void testUpdateUser(){



    }

}

