package com.school.appointsystem.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class Room implements Serializable {
    private Long id;                // 主键ID
    private String roomNo;          // 咨询室编号（唯一）
    private String campus;          // 校区
    private String building;        // 楼宇
    private String roomNumber;      // 房间号
}