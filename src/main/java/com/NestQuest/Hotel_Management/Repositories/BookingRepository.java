package com.NestQuest.Hotel_Management.Repositories;

import com.NestQuest.Hotel_Management.Entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
