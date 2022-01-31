package com.Multiplex.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Multiplex.Model.BookingDetail;

public interface BookingDetailDAO extends JpaRepository<BookingDetail, Integer>{

}
