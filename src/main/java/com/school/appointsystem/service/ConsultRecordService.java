package com.school.appointsystem.service;

import com.school.appointsystem.entity.ConsultRecord;
import com.school.appointsystem.exception.RecordNotFoundException;
import java.util.List;

public interface ConsultRecordService {
    // 创建预约记录
    void createReserve(ConsultRecord record);
    // 完善咨询记录
    void completeRecord(String recordId, ConsultRecord updateData) throws RecordNotFoundException;
    // 获取所有记录（供导出）
    List<ConsultRecord> getAllRecords();
    // 获取记录总数
    long getRecordCount();
}
