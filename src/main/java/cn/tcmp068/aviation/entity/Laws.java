package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laws {
    private int lawsId;
    private int lawsPart;
    private int lawsVersion;
    private String lawsName;
    private int lawsLogo;//是否显示logo_url法规名称
    private String lawsDownload;
    private String lawsState;

}
