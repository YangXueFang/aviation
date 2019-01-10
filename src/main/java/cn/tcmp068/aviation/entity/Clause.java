package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clause {
    private int clauseId;
    private String clauseTitle;
    private int clauseAs;
   //lawsidint(11)法规外键
    private Catalog catalog;
    private String clauseContext;
    private String key;

}
