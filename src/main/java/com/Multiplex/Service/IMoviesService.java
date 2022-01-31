package com.Multiplex.Service;

import java.util.Optional;

import com.Multiplex.Model.Movies;

public interface IMoviesService {
	
	public Movies addMovie(Movies movies);

	public Optional<Movies> findByMovieId(int movieId);

}
