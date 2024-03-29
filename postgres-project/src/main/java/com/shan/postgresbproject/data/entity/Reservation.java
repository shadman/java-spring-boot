package com.shan.postgresbproject.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name="reservations")
@Data
@ToString
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="reservation_id")
    private long id;

    @Column(name="room_id")
    private long roomId;

    @Column(name="guest_id")
    private long guestId;

    @Column(name="res_date")
    private Date reservationDate;
}
