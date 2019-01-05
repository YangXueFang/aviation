package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Web {
    private int webid;
    private int webstatus;//(1、开启2、关闭)
    private String webtitle;
    private String webyuming;
    private String weblogo;
    private String email;
    private int language;//(1、简体中文2、等等。
}
