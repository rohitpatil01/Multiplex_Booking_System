package com.Multiplex.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Multiplex.Model.Users;

public interface UsersDAO extends JpaRepository<Users, Integer>{

}
