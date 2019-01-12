package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int userId;
    private String userPassword;
    private String userPhone;
    private int userType;
    private Timestamp userDate;
    private int userStatus;
    private List<Consult> consults;
    private List<FeedBack> feedBacks;
}
