package com.school.appointsystem.mapper;

import com.school.appointsystem.entity.CsvLoadLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CsvLoadLogMapper {
    // 插入加载日志
    int insert(CsvLoadLog log);
}
