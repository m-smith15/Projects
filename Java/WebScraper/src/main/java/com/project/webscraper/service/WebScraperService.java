package com.project.webscraper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.webscraper.model.Spell;
import com.project.webscraper.repository.WebScraperRepository;

@Service
public class WebScraperService {
	
	@Autowired
	private WebScraperRepository webScraperRepository;
	
	public Spell saveSpell(Spell spell) {
		webScraperRepository.save(spell);
		return spell;
	}

}
