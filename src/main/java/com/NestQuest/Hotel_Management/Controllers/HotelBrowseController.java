package com.NestQuest.Hotel_Management.Controllers;

import com.NestQuest.Hotel_Management.DTOs.HotelDTO;
import com.NestQuest.Hotel_Management.DTOs.HotelInfoDTO;
import com.NestQuest.Hotel_Management.DTOs.HotelSearchRequestDTO;
import com.NestQuest.Hotel_Management.Services.HotelService;
import com.NestQuest.Hotel_Management.Services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelBrowseController {

    private final InventoryService inventoryService;
    private final HotelService hotelService;

    @GetMapping("/search")
    public ResponseEntity<Page<HotelDTO>>searchHotels(@RequestBody HotelSearchRequestDTO hotelSearchRequestDTO){
     Page<HotelDTO> page=   inventoryService.searchHotels(hotelSearchRequestDTO);
     return ResponseEntity.ok(page);


    }

    @GetMapping("/{hotelId}/info")
    public ResponseEntity<HotelInfoDTO> getHotelInfo(@PathVariable Long hotelId){
        return ResponseEntity.ok(hotelService.getHotelInfo(hotelId));
    }

}
