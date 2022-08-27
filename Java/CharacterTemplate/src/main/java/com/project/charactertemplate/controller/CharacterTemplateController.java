package com.project.charactertemplate.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.charactertemplate.model.CharacterTemplate;
import com.project.charactertemplate.model.Spell;
import com.project.charactertemplate.repository.SpellRepository;
import com.project.charactertemplate.service.CharacterTemplateService;

@Controller
public class CharacterTemplateController {

	@Autowired
	private CharacterTemplateService characterService;
	
	@Autowired
	private SpellRepository spellRepository;
	
	@RequestMapping( value="/home", method=RequestMethod.GET)
	private String home(Model model) throws SQLException {
		
		List<CharacterTemplate> listOfCharacters = characterService.allCharacters();
		model.addAttribute("characters", listOfCharacters);
		
		
		
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dostemplate_schema?serverTimezone=UTC", "root", "root");
//		DatabaseMetaData metaData = con.getMetaData();
//		String[] types = {"TABLE"};
//	    ResultSet tables = metaData.getTables(null, null, "%", types);
//	    while (tables.next()) {
//	    System.out.println(tables.getString("TABLE_NAME"));
//	    }
		
		List<Spell> spellsToAdd = spellRepository.findAll();
		model.addAttribute("spells", spellsToAdd);
		
		
		List<String> uniqueSchools = spellsToAdd.stream()
					.map(Spell::getSchool)
					.distinct()
					.collect(Collectors.toList());
		
		System.out.println(uniqueSchools);
		System.out.println(uniqueSchools.get(0));
		
		List<Spell> findBySchool = spellRepository.findBySchool(uniqueSchools.get(0));
		System.out.println(findBySchool.get(0).getSchool());
		
		model.addAttribute("test", findBySchool);
		
		model.addAttribute("schools", uniqueSchools);
		
		
		System.out.println(spellsToAdd.get(0).getActionPoints());
		System.out.println(spellsToAdd.get(0).getId());
		
		
		return "index.jsp";
	}
	
	@RequestMapping( value="/character/create", method=RequestMethod.GET)
	private String createCharacter(Model model) {
		
		model.addAttribute("character",  new CharacterTemplate());
		
		return "createCharacter.jsp";
	}
	
	@RequestMapping(value="/character/create/new", method=RequestMethod.POST)
	private String createNewCharacter(@Valid @ModelAttribute("character") CharacterTemplate characterTemplate,
									BindingResult result, Model model) {
		
		CharacterTemplate potentialCharacter = characterService.saveCharacter(characterTemplate);
		System.out.println(potentialCharacter);
		if(potentialCharacter != null) {
			return"redirect:/home";
		} else {
			model.addAttribute("character", new CharacterTemplate());
			return "createCharacter.jsp";
		}
	}
	
}
