package com.NestQuest.Hotel_Management.Repositories;

import com.NestQuest.Hotel_Management.Entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepsoitory extends JpaRepository<Hotel,Long> {

}
