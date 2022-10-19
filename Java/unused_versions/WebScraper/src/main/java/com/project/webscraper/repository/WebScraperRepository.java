package com.project.webscraper.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.webscraper.model.Spell;

@Repository
public interface WebScraperRepository extends CrudRepository<Spell, Long>{
	List<Spell> findAll();
	
}
