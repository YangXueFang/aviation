package cn.tcmp068.aviation.entity;

import java.sql.Timestamp;

public class Leave {
    private int leaveId;
    private String leaveText;
    private Timestamp leaveTime;
    private int leaveStatus;
    private User user;
}
