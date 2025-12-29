package com.school.appointsystem.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class Consultant implements Serializable {
    private Long id;                // 主键ID
    private String idCard;          // 身份证号（唯一）
    private String name;            // 姓名
    private String phone;           // 联系电话
    private String school;          // 所在学校（大学咨询师）
    private String company;         // 单位（企业咨询师）
    private String intro;           // 个人简介
    private Integer type;           // 类型：1=大学咨询师，2=企业咨询师
}
