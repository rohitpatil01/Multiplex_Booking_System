package com.Multiplex.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Multiplex.Model.Booking;

public interface BookingDAO extends JpaRepository<Booking, Integer>{

}
