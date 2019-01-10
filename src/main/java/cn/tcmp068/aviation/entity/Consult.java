package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consult {
    private int consultId;
    private String consultName;
    private String consultPhone;
    private Timestamp consultTime;
    private int consultClause;
    private String consultText;
    private Date consultDate;
    private int consultStatus;
    private User user;


    ;
}
