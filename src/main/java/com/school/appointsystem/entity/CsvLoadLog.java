package com.school.appointsystem.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class CsvLoadLog implements Serializable {
    private Long id;                // 主键ID
    private String fileName;        // CSV文件名
    private Date loadTime;          // 加载时间
    private Integer loadCount;      // 加载条数
    private Integer status;         // 状态：1=成功，0=失败
    private String errorMsg;        // 错误信息
}
