package com.school.appointsystem.service.impl;

import com.school.appointsystem.entity.Student;
import com.school.appointsystem.exception.StudentAlreadyExistsException;
import com.school.appointsystem.mapper.StudentMapper;
import com.school.appointsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void addStudent(Student student) throws StudentAlreadyExistsException {
        // 校验学号是否已存在
        Student existingStudent = studentMapper.selectByStudentId(student.getStudentId());
        if (existingStudent != null) {
            throw new StudentAlreadyExistsException("学号" + student.getStudentId() + "已存在");
        }
        // 插入新学生
        studentMapper.insert(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.selectAll();
    }
}
