package com.school.appointsystem.service.impl;

import com.school.appointsystem.entity.Consultant;
import com.school.appointsystem.mapper.ConsultantMapper;
import com.school.appointsystem.service.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConsultantServiceImpl implements ConsultantService {

    @Autowired
    private ConsultantMapper consultantMapper;

    @Override
    public List<Consultant> getAllConsultants() {
        return consultantMapper.selectAll();
    }
}
