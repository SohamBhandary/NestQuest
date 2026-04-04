package com.NestQuest.Hotel_Management.Controllers;

import com.NestQuest.Hotel_Management.DTOs.HotelDTO;
import com.NestQuest.Hotel_Management.Services.HotelService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/hotels")
@RequiredArgsConstructor
@Slf4j
public class HotelController {
    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<HotelDTO> createNewHotel(@RequestBody HotelDTO hotelDTO){
        log.info("Attempting to create a new hotel"+hotelDTO.getName());
        HotelDTO hotelDTO1=hotelService.createNewHotel(hotelDTO);
        return new ResponseEntity<>(hotelDTO1, HttpStatus.CREATED );

    }

    @GetMapping("/{hotelID}")
    public ResponseEntity<HotelDTO> getHotelById(@PathVariable Long hotelID){
        HotelDTO hotelDTO= hotelService.getHotelById(hotelID);
        return ResponseEntity.ok(hotelDTO);
    }

    @PutMapping("/{hotelID}")
    public ResponseEntity<HotelDTO> updateHotelById(@PathVariable Long hotelID,@RequestBody HotelDTO hotelDTO){
        HotelDTO hotel= hotelService.updateHotelById(hotelID,hotelDTO);
        return ResponseEntity.ok(hotel);
    }

    @DeleteMapping("/{hotelID}")
    public ResponseEntity<Void> deleteHotelById(@PathVariable Long hotelID){
        hotelService.deleteHotelById(hotelID);
        return ResponseEntity.noContent().build();


    }

    @PatchMapping("/{hotelID}")
    public ResponseEntity<Void> activateHotelById(@PathVariable Long hotelID){
        hotelService.activateHotel(hotelID);
        return ResponseEntity.noContent().build();


    }




}
