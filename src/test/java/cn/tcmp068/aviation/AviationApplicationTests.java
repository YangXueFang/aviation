package cn.tcmp068.aviation;

import cn.tcmp068.aviation.clause.services.ClauseServices;
import cn.tcmp068.aviation.entity.Clause;
import cn.tcmp068.aviation.entity.User;
import cn.tcmp068.aviation.user.dao.UserMapper;
import cn.tcmp068.aviation.user.services.UserServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AviationApplicationTests {

    @Resource
    private UserMapper userMapper;
    @Autowired
    private UserServices userServices;


    @Autowired
    private ClauseServices clauseServices;

//    @Test
//    public void contextLoads() {
//        User user=new User();
//        user.setUserPhone("143");
//        List<User> u = userMapper.queryAll(user, 1, 5);
//        for(User user1:u){
//            System.out.print(user1);
//        }
//    }


    @Test
    public void testInsert(){
        System.out.println(clauseServices);

        Clause clause=new Clause();
        clause.setCateLogid(1);

        clause.setLawsid(1);
        clause.setClausenumber(1);
        clause.setClausename("qwe");
        clause.setClauseversions(213);
        clause.setClausetitle("zxc");
        clause.setClausetext("asdasdad");
        clause.setClausekeyword("qwejioj");
        clauseServices.insert(clause);
    }

    @Test
    public void testLogin(){
        System.out.println(userServices.login("14315468523","123456"));
    }


}

