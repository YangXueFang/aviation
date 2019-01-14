package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Leave {
    private int leaveId;
    private String leaveText;
    private User user;
    private Timestamp leaveTime;
    private int leaveStatus;



}


