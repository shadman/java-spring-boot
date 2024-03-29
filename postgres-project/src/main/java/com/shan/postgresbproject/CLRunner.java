package com.shan.postgresbproject;

import com.shan.postgresbproject.data.entity.Guest;
import com.shan.postgresbproject.data.entity.Reservation;
import com.shan.postgresbproject.data.entity.Room;
import com.shan.postgresbproject.data.repository.GuestRepository;
import com.shan.postgresbproject.data.repository.ReservationRepository;
import com.shan.postgresbproject.data.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class CLRunner implements CommandLineRunner {

    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    public CLRunner(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository){
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //Rooms
        System.out.println("### SPECIFIC ROOM ###");
        Optional<Room> room = this.roomRepository.findByRoomNumberIgnoreCase("p1");
        System.out.println(room);

        System.out.println("### ROOMS ###");
        List<Room> rooms = this.roomRepository.findAll();
        rooms.forEach(System.out::println);

        //Guests
        System.out.println("### GUESTS ###");
        List<Guest> guests = this.guestRepository.findAll();
        guests.forEach(System.out::println);

        //Reservations
        System.out.println("### RESERVATIONS ###");
        List<Reservation> reservations = this.reservationRepository.findAll();
        reservations.forEach(System.out::println);

        //Specific Reservation
        System.out.println("### SPECIFIC RESERVATION ###");
        Optional<Reservation> reservation = this.reservationRepository.findAllByGuestId(200);
        System.out.println(reservation);
    }
}
