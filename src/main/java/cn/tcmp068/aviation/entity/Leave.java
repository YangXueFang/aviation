package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Leave {
    private Integer leaveid;

    private String leavetext;

    private Integer userid;

    private Date leavetime;

    private Integer leavestatus;


}