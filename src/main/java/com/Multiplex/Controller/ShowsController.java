package com.Multiplex.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Multiplex.Exception.RecordNotFoundException;
import com.Multiplex.Model.Shows;
import com.Multiplex.Service.IShowsService;

@RestController
@RequestMapping(value = "/Shows")
public class ShowsController {
	
	@Autowired
	IShowsService service;

	@RequestMapping(value = "/addShows",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Shows> createShows(@Validated @RequestBody Shows shows) {
		System.out.println("Rest");
		Shows mv = service.addShows(shows);
		return new ResponseEntity<Shows>(mv, HttpStatus.OK);
	}

	@RequestMapping(value = "/{showId}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Shows>> getShowsId(@PathVariable int showId) {
		Optional<Shows> shows = service.findByShowsId(showId);

		if (shows.isPresent()) {
			return new ResponseEntity(shows.get(), HttpStatus.OK);
		} else {
			throw new RecordNotFoundException("Record not found...");
		}
	}

}
