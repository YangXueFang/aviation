package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catalog {
    private int catalogId;
    private Statute statute;//
    private String catalogText;
    private int catalogLevel;
    private int superiorCatalog;
    private int peerNumber;
    private List<Clause> clauses;
}
