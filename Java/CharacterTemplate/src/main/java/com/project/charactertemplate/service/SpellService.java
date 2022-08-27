package com.project.charactertemplate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.charactertemplate.model.Spell;
import com.project.charactertemplate.repository.SpellRepository;

@Service
public class SpellService {
	
	@Autowired
	private SpellRepository spellRepository;

	
	public List<Spell> allSpells(){
		return spellRepository.findAll();
	}
	
	public Spell singleSpell(String name) {
		Optional<Spell> optionalSpell = spellRepository.findByName(name);
			if(optionalSpell.isPresent()) {
				return optionalSpell.get();
			} else {
				return null;
			}
	}
	
	public List<Spell> findBySchool(String school) {
		List<Spell> optionalSpells = spellRepository.findBySchool(school);
		return optionalSpells;
	}
}
