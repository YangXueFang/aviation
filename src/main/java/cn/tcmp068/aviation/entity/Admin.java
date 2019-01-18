package cn.tcmp068.aviation.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Admin {
    private int adminId;
    @NonNull
    private String adminPhone;
    private String adminName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp adminTime;
    private String adminPassword;
    private int adminGrade;
    private int adminStatus;
}
