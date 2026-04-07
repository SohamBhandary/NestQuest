package com.NestQuest.Hotel_Management.DTOs;

import com.NestQuest.Hotel_Management.Entities.Enums.BookingStatus;
import com.NestQuest.Hotel_Management.Entities.Guest;
import com.NestQuest.Hotel_Management.Entities.Hotel;
import com.NestQuest.Hotel_Management.Entities.Room;
import com.NestQuest.Hotel_Management.Entities.User;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class BookingDTO {
    private Long id;
    private Integer roomCount;
    private LocalDate checkInDate;
    private  LocalDate checkOutDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private BookingStatus bookingStatus;
    private Set<GuestDTO> guests;

}
