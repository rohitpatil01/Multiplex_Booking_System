package com.Multiplex.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Multiplex.Model.HallCapacity;
import com.Multiplex.Repository.HallCapacityDAO;

@Service
public class HallCapacityServiceimp implements IHallCapacityService {

	@Autowired
	HallCapacityDAO dao;

	public HallCapacity addHallCapacity(HallCapacity hallCapacity) {
		HallCapacity mv = dao.save(hallCapacity);
		return mv;
		
	}

	@Override
	public Optional<HallCapacity> findByHallCapacityId(int hallCapacityId) {
		// TODO Auto-generated method stub
		return dao.findById(hallCapacityId);
	}

}
