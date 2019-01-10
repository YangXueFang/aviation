package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String password;
    private String phone;
    private int userLevel;
    private Date userJoinDate;
    private List<Consult> consults;
    private List<FeedBack> feedBacks;
}
