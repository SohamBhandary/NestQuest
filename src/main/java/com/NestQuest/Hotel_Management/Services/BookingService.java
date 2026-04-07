package com.NestQuest.Hotel_Management.Services;

import com.NestQuest.Hotel_Management.DTOs.BookingDTO;
import com.NestQuest.Hotel_Management.DTOs.BookingRequestDTO;

public interface BookingService {


    BookingDTO initBooking(BookingRequestDTO bookingRequestDTO);
}
