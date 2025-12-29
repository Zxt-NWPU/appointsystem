package com.school.appointsystem.controller;

import com.school.appointsystem.entity.Room;
import com.school.appointsystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    // GET /api/rooms：获取所有咨询室（供前端预约选择）
    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }
}
