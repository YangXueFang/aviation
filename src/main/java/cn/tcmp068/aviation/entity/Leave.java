package cn.tcmp068.aviation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import java.sql.Timestamp;

=======
import java.util.Date;
>>>>>>> d89664ec0aa157a654e21bb1830ebd251e3afad4
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Leave {
<<<<<<< HEAD
    private int leaveId;
    private String leaveText;
    private User user;
    private Timestamp leaveTime;
    private int leaveStatus;



}
=======
    private Integer leaveid;

    private String leavetext;

    private Integer userid;

    private Date leavetime;

    private Integer leavestatus;


}
>>>>>>> d89664ec0aa157a654e21bb1830ebd251e3afad4
