package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laws {
    private String lawsId;

    private Integer lawsPart;

    private String lawsVersion;

    private String lawsName;

    private Integer lawsStauts;

    private String lawsDownload;

    private String lawsState;

    private String lawsLogo;

    private String lawsFDBName;


}