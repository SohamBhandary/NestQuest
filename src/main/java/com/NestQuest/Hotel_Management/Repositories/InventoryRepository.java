package com.NestQuest.Hotel_Management.Repositories;

import com.NestQuest.Hotel_Management.Entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
