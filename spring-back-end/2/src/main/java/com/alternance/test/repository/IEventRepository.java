package com.alternance.test.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alternance.test.entity.Event;


@Repository
public interface IEventRepository extends JpaRepository<Event, Long> {
	boolean existsByTitre (String titre);
	boolean existsByDate (Date date);
	boolean existsByTitreAndDate (String titre, Date date);
}
