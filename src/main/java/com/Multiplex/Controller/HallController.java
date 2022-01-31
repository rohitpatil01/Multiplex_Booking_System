package com.Multiplex.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Multiplex.Exception.RecordNotFoundException;
import com.Multiplex.Model.Hall;
import com.Multiplex.Service.IHallService;

@RestController
@RequestMapping(value = "/Hall")
public class HallController {

	
	//@PostConstruct
//	public void test() {
//	Hall hall=new Hall();
//	hall.setHallCapacity();
//	hall.setHallDesc(null);
//	hall.ser
//			
	//}
	@Autowired
	IHallService service;

	@RequestMapping(value = "/addHall",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Hall> createHall(@Validated @RequestBody Hall hall) {
		System.out.println("Rest");
		Hall mv = service.addHall(hall);
		return new ResponseEntity<Hall>(mv, HttpStatus.OK);
	}

	@RequestMapping(value = "/{hallId}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Hall>> getHallId(@PathVariable int hallId) {
		Optional<Hall> hall = service.findByHallId(hallId);

		if (hall.isPresent()) {
			return new ResponseEntity(hall.get(), HttpStatus.OK);
		} else {
			throw new RecordNotFoundException("Record not found...");
		}
	}

}
