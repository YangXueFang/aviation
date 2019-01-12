package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laws {
    private Integer lawsid;

    private Integer lawspart;

    private Integer lawsversion;

    private String lawsname;

    private Integer lawslogo;

    private String lawsdownload;

    private String lawsstate;


}