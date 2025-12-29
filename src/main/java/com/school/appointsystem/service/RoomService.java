package com.school.appointsystem.service;

import com.school.appointsystem.entity.Room;
import java.util.List;

public interface RoomService {
    // 获取所有咨询室（供前端选择）
    List<Room> getAllRooms();
}
