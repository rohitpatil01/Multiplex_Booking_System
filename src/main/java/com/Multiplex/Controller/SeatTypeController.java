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
import com.Multiplex.Model.SeatType;
import com.Multiplex.Service.ISeatTypeService;

@RestController
@RequestMapping(value = "/SeatType")
public class SeatTypeController {
	
	@Autowired
	ISeatTypeService service;

	@RequestMapping(value = "/addSeatType",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<SeatType> createSeatType(@Validated @RequestBody SeatType seatType) {
		System.out.println("Rest");
		SeatType mv = service.addSeatType(seatType);
		return new ResponseEntity<SeatType>(mv, HttpStatus.OK);
	}

	@RequestMapping(value = "/{seatTypeId}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<SeatType>> getSeatTypeId(@PathVariable int seatTypeId) {
		Optional<SeatType> seatType = service.findBySeatTypeId(seatTypeId);

		if (seatType.isPresent()) {
			return new ResponseEntity(seatType.get(), HttpStatus.OK);
		} else {
			throw new RecordNotFoundException("Record not found...");
		}
	}

}
