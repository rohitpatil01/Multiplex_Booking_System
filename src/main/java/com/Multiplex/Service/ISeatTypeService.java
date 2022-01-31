package com.Multiplex.Service;

import java.util.Optional;

import com.Multiplex.Model.SeatType;

public interface ISeatTypeService {
	
	public SeatType addSeatType(SeatType seatType);

	public Optional<SeatType> findBySeatTypeId(int seatTypeId);


}
