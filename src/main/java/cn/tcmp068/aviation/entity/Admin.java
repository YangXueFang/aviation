package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private int adminid;
    private String adminphone;
    private String adminname;
    private Date adminjoindate;
    private String adminpassword;
    private int adminlevel;
}
