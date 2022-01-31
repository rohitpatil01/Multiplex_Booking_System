package com.Multiplex.Service;

import java.util.Optional;

import com.Multiplex.Model.Hall;

public interface IHallService {

	public Hall addHall(Hall hall);

	public Optional<Hall> findByHallId(int hallId);

}
