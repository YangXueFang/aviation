package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statute {
    private int statutsId;//法规id
    private String lawsNameAs;
    private String version;
    private String lawsName;
    private int status;//状态(1、显示2、不显示)
    private String lawsImg;
    private String PDFFile;
    private String downLoad;
    private String lawsState;
    private List<Catalog> catalogs;
}
