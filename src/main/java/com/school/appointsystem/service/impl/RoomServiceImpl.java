package com.school.appointsystem.service.impl;

import com.school.appointsystem.entity.Room;
import com.school.appointsystem.mapper.RoomMapper;
import com.school.appointsystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public List<Room> getAllRooms() {
        return roomMapper.selectAll();
    }
}
