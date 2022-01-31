package com.Multiplex.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Multiplex.Model.SeatType;
import com.Multiplex.Repository.SeatTypeDAO;

@Service
public class SeatTypeServiceimp implements ISeatTypeService{
	
	@Autowired
	SeatTypeDAO dao;

	public SeatType addSeatType(SeatType seatType) {
		SeatType mv = dao.save(seatType);
		return mv;

	}

	@Override
	public Optional<SeatType> findBySeatTypeId(int seatTypeId) {
		// TODO Auto-generated method stub
		return dao.findById(seatTypeId);
	}

}
