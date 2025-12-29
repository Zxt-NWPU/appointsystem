package com.school.appointsystem.mapper;

import com.school.appointsystem.entity.ConsultRecord;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ConsultRecordMapper {
    // 插入预约记录
    int insert(ConsultRecord record);
    // 根据ID查询记录
    ConsultRecord selectById(String id);
    // 更新记录（完善咨询信息）
    int updateById(ConsultRecord record);
    // 查询所有记录（供导出）
    List<ConsultRecord> selectAll();
    // 查询记录总数
    long selectCount();
}
