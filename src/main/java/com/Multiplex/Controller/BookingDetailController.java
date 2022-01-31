package com.Multiplex.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Multiplex.Exception.RecordNotFoundException;
import com.Multiplex.Model.BookingDetail;
import com.Multiplex.Service.IBookingDetailService;

@RestController
@RequestMapping(value = "/BookingDetail")
public class BookingDetailController {
	
	@Autowired
	IBookingDetailService service;

	@RequestMapping(value = "/addBookingDetail",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BookingDetail> createBookingDetail(@Validated @RequestBody BookingDetail bookingDetail) {
		System.out.println("Rest");
		BookingDetail mv = service.addBookingDetail(bookingDetail);
		return new ResponseEntity<BookingDetail>(mv, HttpStatus.OK);
	}

	@RequestMapping(value = "/{bookingDetailId}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<BookingDetail>> getBookingDetailId(@PathVariable int bookingDetailId) {
		Optional<BookingDetail> bookingDetail = service.findByBookingDetailId(bookingDetailId);

		if (bookingDetail.isPresent()) {
			return new ResponseEntity(bookingDetail.get(), HttpStatus.OK);
		} else {
			throw new RecordNotFoundException("Record not found...");
		}
	}


}
