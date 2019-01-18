package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int userId;
    private String userPassword;
    private String userPhone;
    private int userType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp userDate;
    private int userStatus;
    private List<Consult> consults;
}
