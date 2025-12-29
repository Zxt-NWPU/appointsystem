package com.school.appointsystem.mapper;

import com.school.appointsystem.entity.Consultant;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ConsultantMapper {
    // 查询所有咨询师
    List<Consultant> selectAll();
    // 根据身份证号查询（避免CSV重复加载）
    Consultant selectByIdCard(String idCard);
    // 插入咨询师（CSV加载用）
    int insert(Consultant consultant);
}
