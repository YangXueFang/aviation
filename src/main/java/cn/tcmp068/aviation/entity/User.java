package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import java.sql.Timestamp;
import java.util.List;

=======
import java.util.Date;
>>>>>>> 3e8d69184e43d708bc594a785ec0a69706855f30
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userid;

    private String userphone;

    private String userpassword;

    private Integer usertype;

    private Date userdate;

    private Integer userstatus;

}