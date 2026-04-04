package com.NestQuest.Hotel_Management.Repositories;

import com.NestQuest.Hotel_Management.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
