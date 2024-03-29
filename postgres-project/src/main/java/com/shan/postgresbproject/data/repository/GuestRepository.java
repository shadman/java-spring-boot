package com.shan.postgresbproject.data.repository;

import com.shan.postgresbproject.data.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GuestRepository extends JpaRepository<Guest, Long> {

}
