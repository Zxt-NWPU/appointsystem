package com.school.appointsystem.controller;

import com.school.appointsystem.entity.Student;
import com.school.appointsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // GET /api/students：获取所有学生
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // POST /api/students：添加学生
    @PostMapping
    public ResponseEntity<Map<String, Object>> addStudent(@RequestBody Student student) {
        Map<String, Object> response = new HashMap<>();
        try {
            studentService.addStudent(student);
            response.put("success", true);
            response.put("msg", "学生信息添加成功");
            response.put("studentId", student.getStudentId());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("msg", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
