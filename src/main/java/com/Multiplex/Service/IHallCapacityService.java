package com.Multiplex.Service;

import java.util.Optional;

import com.Multiplex.Model.HallCapacity;

public interface IHallCapacityService {

	public HallCapacity addHallCapacity(HallCapacity hallCapacity);

	public Optional<HallCapacity> findByHallCapacityId(int hallCapacityId);
	
}
