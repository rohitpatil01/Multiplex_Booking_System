package com.Multiplex.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Multiplex.Model.Shows;

public interface ShowsDAO extends JpaRepository<Shows, Integer> {

}
