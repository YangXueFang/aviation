package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consult {
    private int consultId;
    private Clause clause;
    private String consultContext;
    private Date consultDate;
    private User user;
    private int consultStatus;
    private String consultName;
    private String consultPhone;
}
