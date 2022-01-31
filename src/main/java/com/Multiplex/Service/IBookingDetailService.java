package com.Multiplex.Service;

import java.util.Optional;

import com.Multiplex.Model.BookingDetail;

public interface IBookingDetailService {
	
	public BookingDetail addBookingDetail(BookingDetail bookingDetail);

	public Optional<BookingDetail> findByBookingDetailId(int bookingDetailId);

}
