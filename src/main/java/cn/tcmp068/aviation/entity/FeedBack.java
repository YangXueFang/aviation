package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedBack {
    private int feedBackId;
    private String feedBackContent;
    private Date feedBackDate;
    private User user;
    private int feedBackStatus;
}
