package com.NestQuest.Hotel_Management.Services;

import com.NestQuest.Hotel_Management.DTOs.HotelDTO;
import com.NestQuest.Hotel_Management.DTOs.HotelSearchRequestDTO;
import com.NestQuest.Hotel_Management.Entities.Room;
import org.springframework.data.domain.Page;

public interface InventoryService {
    void initializeRoomForAYear(Room room);
    void deleteAllInventories(Room room);

    Page<HotelDTO> searchHotels(HotelSearchRequestDTO hotelSearchRequestDTO);
}
