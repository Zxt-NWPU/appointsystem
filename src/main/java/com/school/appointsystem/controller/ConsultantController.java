package com.school.appointsystem.controller;

import com.school.appointsystem.entity.Consultant;
import com.school.appointsystem.service.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/consultants") // 与前端接口路径一致
public class ConsultantController {

    @Autowired
    private ConsultantService consultantService;

    // GET /api/consultants：获取所有咨询师
    @GetMapping
    public List<Consultant> getAllConsultants() {
        return consultantService.getAllConsultants();
    }
}
