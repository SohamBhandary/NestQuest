package com.NestQuest.Hotel_Management.DTOs;

import com.NestQuest.Hotel_Management.Entities.HotelContactInfo;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class HotelDTO {
    private Long id;
    private String name;
    private String city;
    private String[] photos;
    private String[] amenities;
    private Boolean isActive;

    private HotelContactInfo contactInfo;
}
