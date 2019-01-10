package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catalog {
    private int catalogId;
    private int cataLaws;
    private String cateText;
    private int cateGrade;
    private int cateRank;
    private int cateNumber;
    private List<Clause> clauses;
}
