package com.shan.servicelayer;

import com.shan.servicelayer.data.repository.GuestRepository;
import com.shan.servicelayer.data.repository.ReservationRepository;
import com.shan.servicelayer.data.repository.RoomRepository;
import com.shan.servicelayer.service.RoomReservationService;
import com.shan.servicelayer.service.model.RoomReservation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CLRunner implements CommandLineRunner {

    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;
    private final RoomReservationService roomReservationService;

    public CLRunner(RoomRepository roomRepository, GuestRepository guestRepository,
                    ReservationRepository reservationRepository, RoomReservationService roomReservationService){
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
        this.roomReservationService = roomReservationService;
    }

    @Override
    public void run(String... args) throws Exception {
        List<RoomReservation> reservations = this.roomReservationService.getRoomReservationForDate("2023-08-28");
        reservations.forEach(System.out::println);
    }
}
