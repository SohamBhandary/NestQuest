package com.NestQuest.Hotel_Management.Services;

import com.NestQuest.Hotel_Management.DTOs.RoomDTO;
import com.NestQuest.Hotel_Management.Entities.Room;

import java.util.List;

public interface RoomService {

    RoomDTO createNewRoom(Long hotelID,RoomDTO roomDTO);
    List<RoomDTO> getAllRooms(Long hotelId);
    RoomDTO getRoomById(Long roomId);
    void deleteRoomById(Long roomId);


}
