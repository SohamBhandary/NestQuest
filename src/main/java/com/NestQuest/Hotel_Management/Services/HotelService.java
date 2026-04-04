package com.NestQuest.Hotel_Management.Services;

import com.NestQuest.Hotel_Management.DTOs.HotelDTO;
import com.NestQuest.Hotel_Management.Entities.Hotel;

public interface HotelService {
    HotelDTO createNewHotel(HotelDTO hotelDTO);
    HotelDTO getHotelById(Long id);

    HotelDTO updateHotelById(Long id, HotelDTO hotelDTO);
    void deleteHotelById(Long id);
    void activateHotel(Long hotelId);

}
