package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private int adminId;
    private String adminPhone;
    private String adminName;
    private Date adminJoinDate;
    private String adminPassword;
    private int adminLevel;
    private int adminStatus;
}
