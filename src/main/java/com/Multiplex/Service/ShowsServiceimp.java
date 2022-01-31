package com.Multiplex.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Multiplex.Model.Shows;
import com.Multiplex.Repository.ShowsDAO;

@Service
public class ShowsServiceimp implements IShowsService{
	
	@Autowired
	ShowsDAO dao;

	public Shows addShows(Shows shows) {
		Shows mv = dao.save(shows); 
		return mv;

	}

	@Override
	public Optional<Shows> findByShowsId(int showId) {
		// TODO Auto-generated method stub
		return dao.findById(showId);
	}

}
