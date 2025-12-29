package com.school.appointsystem.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class Student implements Serializable {
    private Long id;                // 主键ID
    private String studentId;       // 学号（唯一）
    private String name;            // 姓名
    private String gender;          // 性别：男/女
    private String college;         // 学院
    private String phone;           // 联系电话
    private Date birthday;          // 生日
    private String remark;          // 备注
}
