package com.don.inventoryservice.repository;

import com.don.inventoryservice.model.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
