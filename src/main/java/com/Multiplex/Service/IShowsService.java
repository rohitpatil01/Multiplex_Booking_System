package com.Multiplex.Service;

import java.util.Optional;

import com.Multiplex.Model.Shows;

public interface IShowsService {
	
	public Shows addShows(Shows shows);

	public Optional<Shows> findByShowsId(int showId);


}
