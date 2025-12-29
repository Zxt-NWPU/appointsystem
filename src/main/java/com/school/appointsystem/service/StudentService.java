package com.school.appointsystem.service;

import com.school.appointsystem.entity.Student;
import com.school.appointsystem.exception.StudentAlreadyExistsException;
import java.util.List;

public interface StudentService {
    // 添加学生（校验学号唯一）
    void addStudent(Student student) throws StudentAlreadyExistsException;
    // 获取所有学生
    List<Student> getAllStudents();
}
