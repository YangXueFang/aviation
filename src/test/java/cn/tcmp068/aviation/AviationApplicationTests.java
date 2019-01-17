package cn.tcmp068.aviation;

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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AviationApplicationTests {

    @Resource
    private UserMapper userMapper;
    @Resource
    private AdminMapper adminMapper;
    @Resource
    private ConsultMapper consultMapper;
    @Resource
    private LeaveMapper leaveMapper;
    @Resource
    private LawsService lawsService;

    @Test
    public void addLeave(){
            Leave leave=new Leave();
            leave.setLeaveText("ww");
        System.out.println(this.leaveMapper.addLeave(leave,1));
    }
    @Test
    public void Consult(){
        System.out.println(this.consultMapper.queryAllByuserId(1));
    }

    @Test
    public void contextLoads() {
        User user=new User();
        user.setUserPhone("143");
        List<User> u = userMapper.queryAll(user, 1, 5);
        for(User user1:u){
            System.out.print(user1);
        }
    }
    @Test
    public void List() {
        Consult consult=new Consult();
        consult.setConsultText("一");
        List<Consult> u = consultMapper.queryAll(consult, 1, 5);
        for(Consult user1:u){
            System.out.print(user1);
        }
    }

//    @Test
//    public void addAdmin(){
//        Admin admin=new Admin();
//        admin.setAdminName("a");
//        admin.setAdminPhone("12345678901");
//        admin.setAdminPassword("qq");
//        admin.setAdminStatus(1);
//        System.out.println(this.adminMapper.addAdmin(admin));
//    }
    @Test
    public void testQueryAllLows(){
        Laws laws=new Laws();
        PageInfo<Laws> list=lawsService.queryAll(laws,1,5);
        for (Laws la : list.getList()){
            System.out.println(la);
        }
    }


    @Test
    public void testAddLaws(){
        Laws laws=new Laws();
        laws.setLawsId("CARE-34-R1");
        laws.setLawsPart(34);
        laws.setLawsVersion("R1");
        laws.setLawsName("CARE");
        laws.setLawsStauts(1);
        laws.setLawsDownload("https://xiazai");
        laws.setLawsState("版本说明");
        laws.setLawsLogo("/LogoCARE.jpg");
        laws.setLawsFDBName("FDBmingc");
        System.out.println(this.lawsService.addLaws(laws));



    }


}

