package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clause {
    private int clauseId;
    private Catalog catalog;
    private int lawsId;
    private int clauseNumber;
    private String clauseName;
    private int clauseVersions;
    private String clauseTitle;
    private String clauseText;
    private String clauseKeyword;

}
