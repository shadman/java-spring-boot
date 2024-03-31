package com.shan.mvcpattern.data.repository;

import com.shan.mvcpattern.data.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GuestRepository extends JpaRepository<Guest, Long> {

}
