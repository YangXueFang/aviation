package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Smtp {
    private int id;
    private String email;
    private String server;
    private String name;
    private String pwd;
    private String Once;
    private String type;
}
