package com.school.appointsystem.service.impl;

import com.school.appointsystem.entity.ConsultRecord;
import com.school.appointsystem.exception.RecordNotFoundException;
import com.school.appointsystem.mapper.ConsultRecordMapper;
import com.school.appointsystem.service.ConsultRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConsultRecordServiceImpl implements ConsultRecordService {

    @Autowired
    private ConsultRecordMapper consultRecordMapper;

    @Override
    public void createReserve(ConsultRecord record) {
        record.setStatus(1); // 初始化状态：1=已预约
        consultRecordMapper.insert(record);
    }

    @Override
    public void completeRecord(String recordId, ConsultRecord updateData) throws RecordNotFoundException {
        // 查询记录是否存在
        ConsultRecord existingRecord = consultRecordMapper.selectById(recordId);
        if (existingRecord == null) {
            throw new RecordNotFoundException("预约记录ID：" + recordId + " 不存在");
        }
        // 更新字段
        existingRecord.setEndTime(updateData.getEndTime());
        existingRecord.setQuestion(updateData.getQuestion());
        existingRecord.setConclusion(updateData.getConclusion());
        existingRecord.setStatus(2); // 状态改为：2=已完成
        // 保存更新
        consultRecordMapper.updateById(existingRecord);
    }

    @Override
    public List<ConsultRecord> getAllRecords() {
        return consultRecordMapper.selectAll();
    }

    @Override
    public long getRecordCount() {
        return consultRecordMapper.selectCount();
    }
}
