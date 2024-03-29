package com.shan.postgresbproject;

import com.shan.postgresbproject.data.entity.Room;
import com.shan.postgresbproject.data.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CLRunner implements CommandLineRunner {

    private final RoomRepository roomRepository;

    public CLRunner(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Optional<Room> room = this.roomRepository.findByRoomNumberIgnoreCase("p1");
        System.out.println(room);

        List<Room> rooms = this.roomRepository.findAll();
        rooms.forEach(System.out::println);

    }
}
