package com.NestQuest.Hotel_Management.Services;

import com.NestQuest.Hotel_Management.DTOs.RoomDTO;
import com.NestQuest.Hotel_Management.Entities.Hotel;
import com.NestQuest.Hotel_Management.Entities.Room;
import com.NestQuest.Hotel_Management.Exceptions.ResourceNotFoundException;
import com.NestQuest.Hotel_Management.Repositories.HotelRepsoitory;
import com.NestQuest.Hotel_Management.Repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomServiceImple implements RoomService {

    private final RoomRepository roomRepository;
    private final ModelMapper modelMapper;
    private final HotelRepsoitory hotelRepsoitory;

    @Override
    public RoomDTO createNewRoom(Long HotelID,RoomDTO roomDTO) {
        log.info("Creating a new room in hotel with id :{}",HotelID);
        Hotel hotel=   hotelRepsoitory.findById(HotelID).
                orElseThrow(()->new ResourceNotFoundException("Hotel not found with id"+HotelID));
        Room room= modelMapper.map(roomDTO,Room.class);
        room.setHotel(hotel);
        room=roomRepository.save(room);
        return modelMapper.map(room,RoomDTO.class);

    }

    @Override
    public List<RoomDTO> getAllRooms(Long hotelId) {
        log.info("Getting all rooms in hotel with id {}",hotelId);
        Hotel hotel=   hotelRepsoitory.findById(hotelId).
                orElseThrow(()->new ResourceNotFoundException("Hotel not found with id:"+hotelId));
       return hotel.getRooms()
               .stream()
               .map((e)->modelMapper.map(e,RoomDTO.class)).collect(Collectors.toList());
    }

    @Override
    public RoomDTO getRoomById(Long roomId) {
        log.info("Getting room with  id :{}",roomId);
        Room room=   roomRepository.findById(roomId).
                orElseThrow(()->new ResourceNotFoundException("Room not found with id: "+ roomId));

        return modelMapper.map(room,RoomDTO.class);
    }

    @Override
    public void deleteRoomById(Long roomId) {
        log.info("Deleting room with  id :{}",roomId);
        boolean exsists=roomRepository.existsById(roomId);
        if(!exsists) throw new ResourceNotFoundException("Room not found with id:{}"+roomId);
        roomRepository.deleteById(roomId);


    }
}
