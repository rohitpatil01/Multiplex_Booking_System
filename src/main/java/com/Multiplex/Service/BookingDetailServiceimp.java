package com.Multiplex.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Multiplex.Model.BookingDetail;
import com.Multiplex.Repository.BookingDetailDAO;

@Service
public class BookingDetailServiceimp implements IBookingDetailService{
	
	@Autowired
	BookingDetailDAO dao;

	public BookingDetail addBookingDetail(BookingDetail bookingDetail) {
		BookingDetail mv = dao.save(bookingDetail);
		return mv;

	}

	@Override
	public Optional<BookingDetail> findByBookingDetailId(int bookingDetailId) {
		return dao.findById(bookingDetailId);
	}

}
