package com.school.appointsystem.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class ConsultRecord implements Serializable {
    private String id;              // 预约记录ID（前端生成）
    private String studentName;     // 学生姓名
    private String consultantName;  // 咨询师姓名
    private String roomNo;          // 咨询室编号
    private Date startTime;         // 起始时间
    private Date endTime;           // 结束时间
    private String question;        // 咨询问题
    private String conclusion;      // 咨询结论
    private Integer status;         // 状态：1=已预约，2=已完成
}
