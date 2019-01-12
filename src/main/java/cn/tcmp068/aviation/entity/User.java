package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userid;

    private String userphone;

    private String userpassword;

    private Integer usertype;

    private Date userdate;

    private Integer userstatus;

}