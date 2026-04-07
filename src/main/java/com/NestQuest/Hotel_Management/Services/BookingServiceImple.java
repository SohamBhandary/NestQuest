package com.NestQuest.Hotel_Management.Services;

import com.NestQuest.Hotel_Management.DTOs.BookingDTO;
import com.NestQuest.Hotel_Management.DTOs.BookingRequestDTO;
import com.NestQuest.Hotel_Management.Entities.*;
import com.NestQuest.Hotel_Management.Entities.Enums.BookingStatus;
import com.NestQuest.Hotel_Management.Exceptions.ResourceNotFoundException;
import com.NestQuest.Hotel_Management.Repositories.BookingRepository;
import com.NestQuest.Hotel_Management.Repositories.HotelRepository;
import com.NestQuest.Hotel_Management.Repositories.InventoryRepository;
import com.NestQuest.Hotel_Management.Repositories.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookingServiceImple implements BookingService{
    private final ModelMapper modelMapper;
    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;
    private final HotelRepository hotelRepository;
    private final InventoryRepository inventoryRepository;
    @Override
    @Transactional
    public BookingDTO initBooking(BookingRequestDTO bookingRequestDTO) {
        log.info("Initialising booking for hotel :{},room:{},date{}-{}",bookingRequestDTO.getHotelId(),bookingRequestDTO.getRoomId(),bookingRequestDTO.getCheckInDate(),bookingRequestDTO.getCheckOutDate());

        Hotel hotel=hotelRepository.
                findById(bookingRequestDTO.getHotelId()).
                orElseThrow(()->
                        new ResourceNotFoundException("Hotel not found with the id:"+bookingRequestDTO.getHotelId()));

        Room room=roomRepository.
                findById(bookingRequestDTO.getHotelId()).
                orElseThrow(()->
                        new ResourceNotFoundException("Hotel not found with the id:"+bookingRequestDTO.getRoomId()));


        List<Inventory> inventoryList=inventoryRepository.
                findAndLockAvailableInventory(room.getId(),bookingRequestDTO.getCheckInDate(),bookingRequestDTO.getCheckOutDate(),bookingRequestDTO.getRoomsCount());

        long daysCount= ChronoUnit.DAYS.between(bookingRequestDTO.getCheckInDate(),bookingRequestDTO.getCheckOutDate())+1;
        if(inventoryList.size()!=daysCount){
            throw new IllegalStateException("Room is not avavaible anymore");
        }
        for(Inventory i :inventoryList){
            i.setReservedCount(i.getReservedCount()+bookingRequestDTO.getRoomsCount());

        }
        inventoryRepository.saveAll(inventoryList);

        User user= new User();
        user.setId(1L);

        Booking booking=Booking.builder().bookingStatus(BookingStatus.RESERVED)
                .hotel(hotel)
                .room(room)
                .checkInDate(bookingRequestDTO.getCheckInDate())
                .checkOutDate(bookingRequestDTO.getCheckOutDate())
                .user(user)
                .roomCount(bookingRequestDTO.getRoomsCount())
                .amount(BigDecimal.TEN)
                .build();

        booking=bookingRepository.save(booking);
        return modelMapper.map(booking, BookingDTO.class);



    }
}
