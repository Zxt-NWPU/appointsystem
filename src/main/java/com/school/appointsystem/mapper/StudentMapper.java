package com.school.appointsystem.mapper;

import com.school.appointsystem.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface StudentMapper {
    // 根据学号查询（校验重复）
    Student selectByStudentId(String studentId);
    // 插入学生
    int insert(Student student);
    // 查询所有学生
    List<Student> selectAll();
}
