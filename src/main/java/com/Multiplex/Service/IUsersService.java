package com.Multiplex.Service;

import java.util.Optional;

import com.Multiplex.Model.Users;

public interface IUsersService {
	
	public Users addUser(Users users);

	public Optional<Users> findByUserId(int userId);

}
