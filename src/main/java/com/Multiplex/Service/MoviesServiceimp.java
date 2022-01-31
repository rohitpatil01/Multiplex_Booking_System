package com.Multiplex.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Multiplex.Model.Movies;
import com.Multiplex.Repository.MoviesDAO;

@Service
public class MoviesServiceimp implements IMoviesService {
	
	@Autowired
	MoviesDAO dao;

	public Movies addMovie(Movies movies) {
		Movies mv = dao.save(movies);
		return mv;

	}

	@Override
	public Optional<Movies> findByMovieId(int movieId) {
		// TODO Auto-generated method stub
		return dao.findById(movieId);
	}

}
