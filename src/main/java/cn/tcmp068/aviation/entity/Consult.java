package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consult {
    private int consultId;
    private String consultName;
    private String consultPhone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp consultTime;
    private int consultClause;
    private String consultText;
    private int consultStatus;
    private User user;
}
