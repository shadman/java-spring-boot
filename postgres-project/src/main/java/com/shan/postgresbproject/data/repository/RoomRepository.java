package com.shan.postgresbproject.data.repository;

import com.shan.postgresbproject.data.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByRoomNumberIgnoreCase(String roomNumber);
}
