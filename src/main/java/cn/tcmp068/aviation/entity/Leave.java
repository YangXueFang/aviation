package cn.tcmp068.aviation.entity;

import java.util.Date;

public class Leave {
    private Integer leaveid;

    private String leavetext;

    private Integer userid;

    private Date leavetime;

    private Integer leavestatus;

    public Integer getLeaveid() {
        return leaveid;
    }

    public void setLeaveid(Integer leaveid) {
        this.leaveid = leaveid;
    }

    public String getLeavetext() {
        return leavetext;
    }

    public void setLeavetext(String leavetext) {
        this.leavetext = leavetext == null ? null : leavetext.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(Date leavetime) {
        this.leavetime = leavetime;
    }

    public Integer getLeavestatus() {
        return leavestatus;
    }

    public void setLeavestatus(Integer leavestatus) {
        this.leavestatus = leavestatus;
    }
}