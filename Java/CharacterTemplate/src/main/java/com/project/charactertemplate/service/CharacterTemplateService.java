package com.project.charactertemplate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.project.charactertemplate.model.CharacterTemplate;
import com.project.charactertemplate.repository.CharacterTemplateRepository;

@Service
public class CharacterTemplateService {

	@Autowired
	private CharacterTemplateRepository characterTemplateRepository;
	
	public List<CharacterTemplate> allCharacters(){
		return characterTemplateRepository.findAll();
	}
	
	public CharacterTemplate singleCharacter(String name) {
		Optional<CharacterTemplate> optionalCharacter = characterTemplateRepository.findByName(name);
			if(optionalCharacter.isPresent()) {
				return optionalCharacter.get();
			} else {
				return null;
			}
	}
	public CharacterTemplate createCharacter(CharacterTemplate characterTemplate, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		} else {
			characterTemplateRepository.save(characterTemplate);
			return characterTemplate;
		}
	}
	public CharacterTemplate saveCharacter(CharacterTemplate characterTemplate) {
		characterTemplateRepository.save(characterTemplate);
		return characterTemplate;
		
	}

}
