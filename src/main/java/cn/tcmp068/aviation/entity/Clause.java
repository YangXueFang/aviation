package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clause {


    private Integer clauseid;

    private Integer cateLogid;

    private Integer lawsid;

    private Integer clausenumber;

    private String clausename;

    private Integer clauseversions;

    private String clausetitle;

    private String clausetext;

    private String clausekeyword;
    private Catalog catalog;


}
