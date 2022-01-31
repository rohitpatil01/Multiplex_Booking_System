package com.Multiplex.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Multiplex.Model.Users;
import com.Multiplex.Repository.UsersDAO;

@Service
public class UsersServiceimp implements IUsersService {
	
	@Autowired
	UsersDAO dao;

	public Users addUser(Users users) {
		Users mv = dao.save(users);
		return mv;

	}

	@Override
	public Optional<Users> findByUserId(int userId) {
		// TODO Auto-generated method stub
		return dao.findById(userId);
	}

}
