package com.Multiplex.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Multiplex.Model.Movies;

public interface MoviesDAO extends JpaRepository<Movies, Integer>{

}
