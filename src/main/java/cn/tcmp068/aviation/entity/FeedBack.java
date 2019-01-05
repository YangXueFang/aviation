package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedBack {
    private int feedbackid;
    private String feedbackcontent;
    private Date feedbackDate;
}
