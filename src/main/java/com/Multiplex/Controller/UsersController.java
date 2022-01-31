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
import com.Multiplex.Model.Users;
import com.Multiplex.Service.IUsersService;

@RestController
@RequestMapping(value = "/Users")
public class UsersController {
	
	@Autowired
	IUsersService service;

	@RequestMapping(value = "/addUsers",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Users> createUser(@Validated @RequestBody Users users) {
		System.out.println("Rest");
		Users mv = service.addUser(users);
		return new ResponseEntity<Users>(mv, HttpStatus.OK);
	}

	@RequestMapping(value = "/{userId}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Users>> getUserId(@PathVariable int userId) {
		Optional<Users> users = service.findByUserId(userId);

		if (users.isPresent()) {
			return new ResponseEntity(users.get(), HttpStatus.OK);
		} else {
			throw new RecordNotFoundException("Record not found...");
		}
	}

}
