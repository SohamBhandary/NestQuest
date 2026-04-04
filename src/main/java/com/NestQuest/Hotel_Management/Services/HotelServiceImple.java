package com.NestQuest.Hotel_Management.Services;

import com.NestQuest.Hotel_Management.DTOs.HotelDTO;
import com.NestQuest.Hotel_Management.Entities.Hotel;
import com.NestQuest.Hotel_Management.Exceptions.ResourceNotFoundException;
import com.NestQuest.Hotel_Management.Repositories.HotelRepsoitory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor

public class HotelServiceImple implements HotelService{

    private final HotelRepsoitory hotelRepsoitory;
    private final ModelMapper modelMapper;


    @Override
    public HotelDTO createNewHotel(HotelDTO hotelDTO) {
        log.info("Creating new hotel with name :{}",hotelDTO.getName());
        Hotel hotel= modelMapper.map(hotelDTO,Hotel.class);
        hotel.setIsActive(false);
        hotel=hotelRepsoitory.save(hotel);
        log.info("Created a new hotel with id :{}",hotel.getId());
        return modelMapper.map(hotel,HotelDTO.class);



    }

    @Override
    public HotelDTO getHotelById(Long id) {

        log.info("Getting hotel with id:{}",id);
     Hotel hotel=   hotelRepsoitory.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel not found with id"+id));
     return modelMapper.map(hotel,HotelDTO.class) ;

    }

    @Override
    public HotelDTO updateHotelById(Long id, HotelDTO hotelDTO) {
        log.info("Updating hotel with id:{}",id);
        Hotel hotel=   hotelRepsoitory.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Hotel not found with id"+id));

        modelMapper.map(hotelDTO,hotel);
        hotel.setId(id);
       hotel= hotelRepsoitory.save(hotel);
       return modelMapper.map(hotel,HotelDTO.class);

    }

    @Override
    public void deleteHotelById(Long id) {
        boolean exsits=hotelRepsoitory.existsById(id);
        if(!exsits) throw  new ResourceNotFoundException("Hotel not found with id"+id);
        hotelRepsoitory.deleteById(id);


    }

    @Override
    public void activateHotel(Long hotelId) {
        log.info("Activiting hotel with id:{}",hotelId);
        Hotel hotel=   hotelRepsoitory.findById(hotelId).
                orElseThrow(()->new ResourceNotFoundException("Hotel not found with id"+hotelId));
        hotel.setIsActive(true);




    }
}
