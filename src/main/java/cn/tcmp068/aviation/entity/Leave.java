package cn.tcmp068.aviation.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Leave {
    private int leaveId;
    @NonNull
    private String leaveText;
    private User user;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp leaveTime;
    private int leaveStatus;



}


