package com.school.appointsystem.service;

import com.school.appointsystem.entity.Consultant;
import java.util.List;

public interface ConsultantService {
    // 获取所有咨询师（供前端展示）
    List<Consultant> getAllConsultants();
}
