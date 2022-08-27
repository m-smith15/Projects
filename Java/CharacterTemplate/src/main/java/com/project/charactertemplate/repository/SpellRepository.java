package com.project.charactertemplate.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.charactertemplate.model.Spell;

@Repository
public interface SpellRepository extends CrudRepository<Spell, Long>{

	List<Spell> findAll();
	Optional<Spell> findByName(String name);
	List<Spell> findBySchool(String school);
	List<Spell> findDistinctBySchool(String school);
	
	
}
