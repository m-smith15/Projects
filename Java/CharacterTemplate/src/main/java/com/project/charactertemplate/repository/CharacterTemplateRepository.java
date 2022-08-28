package com.project.charactertemplate.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.charactertemplate.model.CharacterTemplate;

@Repository
public interface CharacterTemplateRepository extends CrudRepository<CharacterTemplate, Long> {

	List<CharacterTemplate> findAll();
	Optional<CharacterTemplate> findById(Long id);
	
}
