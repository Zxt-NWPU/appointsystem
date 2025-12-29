package com.school.appointsystem.mapper;

import com.school.appointsystem.entity.Room;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface RoomMapper {
    // 根据编号查询（避免CSV重复加载）
    Room selectByRoomNo(String roomNo);
    // 插入咨询室
    int insert(Room room);
    // 查询所有咨询室（供前端选择）
    List<Room> selectAll();
}
