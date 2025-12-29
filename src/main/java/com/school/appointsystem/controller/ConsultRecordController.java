package com.school.appointsystem.controller;

import com.school.appointsystem.entity.ConsultRecord;
import com.school.appointsystem.service.ConsultRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ConsultRecordController {

    @Autowired
    private ConsultRecordService consultRecordService;

    // POST /api/reserves：创建预约
    @PostMapping("/reserves")
    public ResponseEntity<Map<String, Object>> createReserve(@RequestBody ConsultRecord record) {
        Map<String, Object> response = new HashMap<>();
        try {
            consultRecordService.createReserve(record);
            response.put("success", true);
            response.put("msg", "预约成功");
            response.put("recordId", record.getId());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("msg", "预约失败：" + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    // PUT /api/records/{id}：完善预约记录
    @PutMapping("/records/{id}")
    public ResponseEntity<Map<String, Object>> completeRecord(
            @PathVariable String id,
            @RequestBody ConsultRecord updateData) {
        Map<String, Object> response = new HashMap<>();
        try {
            consultRecordService.completeRecord(id, updateData);
            response.put("success", true);
            response.put("msg", "记录完善成功");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("msg", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    // GET /api/records：获取所有预约记录（供导出）
    @GetMapping("/records")
    public List<ConsultRecord> getAllRecords() {
        return consultRecordService.getAllRecords();
    }

    // GET /api/records/count：获取记录总数
    @GetMapping("/records/count")
    public long getRecordCount() {
        return consultRecordService.getRecordCount();
    }
}
