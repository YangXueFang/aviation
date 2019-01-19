package cn.tcmp068.aviation;

import cn.tcmp068.aviation.clause.services.ClauseServices;
import cn.tcmp068.aviation.entity.Clause;
import cn.tcmp068.aviation.entity.User;
import cn.tcmp068.aviation.admin.dao.AdminMapper;
import cn.tcmp068.aviation.catalog.services.CatalogServices;
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

//    @Test
//    public void contextLoads() {
//        User user=new User();
//        user.setUserPhone("143");
//        List<User> u = userMapper.queryAll(user, 1, 5);
//        for(User user1:u){
//            System.out.print(user1);
//        }
//    }


//    @Test
//    public void testInsert() {
//        System.out.println(clauseServices);
//
//        Clause clause = new Clause();
//        clause.setCateLogid(1);
//
//        clause.setLawsid(1);
//        clause.setClausenumber(1);
//        clause.setClausename("qwe");
//        clause.setClauseversions(213);
//        clause.setClausetitle("zxc");
//        clause.setClausetext("asdasdad");
//        clause.setClausekeyword("qwejioj");
//        clauseServices.insert(clause);
//    @Resource
//    private AdminMapper adminMapper;
//    @Resource
//    private ConsultMapper consultMapper;
//    @Resource
//    private LeaveMapper leaveMapper;
//    @Resource
//    private LawsService lawsService;
//    @Resource
//    private CatalogServices catalogServices;
//
//    @Test
//    public void addLeave(){
//            Leave leave=new Leave();
//            leave.setLeaveText("ww");
//        System.out.println(this.leaveMapper.addLeave(leave));
//    }
//    @Test
//    public void Consult(){
//        System.out.println(this.catalogServices.queryAllCatalog("CARE-23-R1",1,4));
//    }
//    @Test
//    public void Consultdetail(){
//        System.out.println(this.consultMapper.queryConsultByuserId(11));
//    }
//
//    @Test
//    public void testLogin(){
//        System.out.println(userServices.login("14315468523","123456"));
//    }
//    @Test
//    public void List() {
//        Consult consult=new Consult();
//        consult.setConsultText("一");
//        List<Consult> u = consultMapper.queryAll(consult, 1, 5);
//        for(Consult user1:u){
//            System.out.print(user1);
//        }
//    }
//
////    @Test
////    public void addAdmin(){
////        Admin admin=new Admin();
////        admin.setAdminName("a");
////        admin.setAdminPhone("12345678901");
////        admin.setAdminPassword("qq");
////        admin.setAdminStatus(1);
////        System.out.println(this.adminMapper.addAdmin(admin));
////    }
//    @Test
//    public void testQueryAllLows(){
//        Laws laws=new Laws();
//        laws.setLawsPart(23);
//
//        PageInfo<Laws> list=lawsService.queryAll(laws,1,5);
//        for (Laws la : list.getList()){
//            System.out.println(la);
//        }
//    }
//
//
//    @Test
//    public void testAddLaws(){
//        Laws laws=new Laws();
//        laws.setLawsId("CARE-34-R1");
//        laws.setLawsPart(34);
//        laws.setLawsVersion("R1");
//        laws.setLawsName("CARE");
//        laws.setLawsStauts(1);
//        laws.setLawsDownload("https://xiazai");
//        laws.setLawsState("版本说明");
//        laws.setLawsLogo("/LogoCARE.jpg");
//        laws.setLawsFDBName("FDBmingc");
//        System.out.println(this.lawsService.addLaws(laws));
//
//
//
//    }


    }

}

