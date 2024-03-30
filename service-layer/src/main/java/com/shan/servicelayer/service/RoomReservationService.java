package com.shan.servicelayer.service;

import com.shan.servicelayer.data.entity.Guest;
import com.shan.servicelayer.data.entity.Reservation;
import com.shan.servicelayer.data.entity.Room;
import com.shan.servicelayer.data.repository.GuestRepository;
import com.shan.servicelayer.data.repository.RoomRepository;
import com.shan.servicelayer.data.repository.ReservationRepository;
import com.shan.servicelayer.service.model.RoomReservation;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RoomReservationService {
    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    public RoomReservationService(GuestRepository guestRepository, RoomRepository roomRepository, ReservationRepository reservationRepository) {
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservationForDate(String reservationDate){

        Date date = null;
        if (StringUtils.isNotEmpty(reservationDate)) {
            date = Date.valueOf(reservationDate);
        } else {
            date = new Date(new java.util.Date().getTime());
        }

        Map<Long, RoomReservation> roomReservations = new HashMap<>();

        // Getting Rooms and setting all rooms reservations in array
        List<Room> rooms = this.roomRepository.findAll();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getRoomNumber());

            roomReservations.put(roomReservation.getRoomId(), roomReservation);
        });

        // Getting existing reservation of desired date from database
        List<Reservation> reservations = this.reservationRepository.findAllByReservationDate(date);
        reservations.forEach(reservation -> {

            // Updating all room reservations with id and date after fetching from DB
            RoomReservation roomReservation = roomReservations.get(reservation.getRoomId());
            roomReservation.setReservationId(reservation.getId());
            roomReservation.setReservationDate(reservation.getReservationDate().toString());

            // Fetching guest information of reservation to update room reservations
            Optional<Guest> guest = this.guestRepository.findById(reservation.getGuestId());
            roomReservation.setGuestId(guest.get().getId());
            roomReservation.setFirstName(guest.get().getFirstName());
            roomReservation.setLastName(guest.get().getLastName());
        });

        // converting into list to return
        return roomReservations.values().stream().toList();
    }

}