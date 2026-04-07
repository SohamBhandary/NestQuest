package com.NestQuest.Hotel_Management.Controllers;

import com.NestQuest.Hotel_Management.DTOs.BookingDTO;
import com.NestQuest.Hotel_Management.DTOs.BookingRequestDTO;
import com.NestQuest.Hotel_Management.Services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class HotelBookingController {
    private final BookingService bookingService;
    @PostMapping("/init")
    public ResponseEntity<BookingDTO> initBooking(@RequestBody BookingRequestDTO bookingRequestDTO){
        return ResponseEntity.ok(bookingService.initBooking(bookingRequestDTO));


    }
}
