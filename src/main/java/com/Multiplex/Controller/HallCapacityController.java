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
import com.Multiplex.Model.HallCapacity;
import com.Multiplex.Service.IHallCapacityService;

@RestController
@RequestMapping(value = "/HallCapacity")
public class HallCapacityController {

	@Autowired
	IHallCapacityService service;	

	@RequestMapping(value = "/addHallCapacity",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<HallCapacity> createHallCapacity(@Validated @RequestBody HallCapacity hallCapacity) {
		System.out.println("Rest");
		HallCapacity mv = service.addHallCapacity(hallCapacity);
		return new ResponseEntity<HallCapacity>(mv, HttpStatus.OK);
	}

	@RequestMapping(value = "/{hallCapacityId}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<HallCapacity>> getHallCapacityId(@PathVariable int hallCapacityId) {
		Optional<HallCapacity> hallCapacity = service.findByHallCapacityId(hallCapacityId);

		if (hallCapacity.isPresent()) {
			return new ResponseEntity(hallCapacity.get(), HttpStatus.OK);
		} else {
			throw new RecordNotFoundException("Record not found...");
		}
	}
}
