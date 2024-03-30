package com.shan.servicelayer.data.repository;

import com.shan.servicelayer.data.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GuestRepository extends JpaRepository<Guest, Long> {

}
