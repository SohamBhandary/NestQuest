package com.NestQuest.Hotel_Management.Controllers;

import com.NestQuest.Hotel_Management.DTOs.RoomDTO;
import com.NestQuest.Hotel_Management.Services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/hotels/{hotelID}/rooms")
@RequiredArgsConstructor
public class RoomAdminController {
    private final RoomService roomService;
    @PostMapping
    public ResponseEntity<RoomDTO> createNewRoom(@PathVariable Long hotelID, @RequestBody RoomDTO roomDTO){

     RoomDTO room=   roomService.createNewRoom(hotelID,roomDTO);
     return new ResponseEntity<>(room,HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<RoomDTO>> getAllRooms(@PathVariable Long hotelID){
        return ResponseEntity.ok(roomService.getAllRooms(hotelID));
    }

    @GetMapping("/{roomID}")
    public ResponseEntity<RoomDTO> getRoomById(@PathVariable Long hotelID,@PathVariable Long roomID){
        return ResponseEntity.ok(roomService.getRoomById(roomID));
    }

    @DeleteMapping("/{roomID}")
    public ResponseEntity<RoomDTO> deleteRoomById(@PathVariable Long hotelID,@PathVariable Long roomID){
        roomService.deleteRoomById(roomID);
        return ResponseEntity.noContent().build();
    }
}
