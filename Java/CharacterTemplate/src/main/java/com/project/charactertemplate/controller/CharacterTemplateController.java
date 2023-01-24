package com.project.charactertemplate.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//doing a cheeky redirect
	@RequestMapping(value="/", method=RequestMethod.GET)
	private String index() { 
	    return "redirect:/home";
	}
	
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
		
//		System.out.println(uniqueSchools);
//		System.out.println(uniqueSchools.get(0));
		
//		List<Spell> findBySchool = spellRepository.findBySchool(uniqueSchools.get(0));
//		System.out.println(findBySchool.get(0).getSchool());
//		
//		model.addAttribute("test", findBySchool);
		
		model.addAttribute("schools", uniqueSchools);
		
		
//		System.out.println(spellsToAdd.get(0).getActionPoints());
//		System.out.println(spellsToAdd.get(0).getId());
		
		
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
	
	@RequestMapping(value="/character/view/{id}", method=RequestMethod.GET)
	private String viewACharacter(Model model, @PathVariable("id") Long id) {
		
		CharacterTemplate viewCharacter = characterService.singleCharacter(id);
		System.out.println(viewCharacter.getAerotheurge_level());
		
		model.addAttribute("character", viewCharacter);
		
		List<Spell> spellsToAdd = spellRepository.findAll();
		Spell firstSpell = spellsToAdd.get(0);
		
		String spellLevel = firstSpell.getRequiredLevel();
		System.out.println(spellLevel);
		spellLevel = spellLevel.substring(1,2);
		System.out.println(spellLevel);
		int spellLevelInt = Integer.parseInt(spellLevel);
		if(spellLevelInt == 1) {
			spellLevel = "it worked";
		} else {
			spellLevel = "it did not work";
		}
		
		List<Spell> spells2Page = new ArrayList<Spell>();
		int i = 0;
		System.out.println(spellsToAdd.size());
		// the -25 removes special/weapon specific and sourcery spells
		while(i < (spellsToAdd.size() - 25)) {
			String temp = spellsToAdd.get(i).getRequiredLevel().toString();
			
			//accounting for odd spacing issues with the scraped data
			int startIndex = temp.indexOf("[");
			int endIndex = temp.indexOf("]");
			temp = temp.substring(startIndex + 1,endIndex).trim();
			
			if(i == 165) {
				System.out.println("temp is comma");
				temp = "1";
			}
			System.out.println(temp);
			if(temp.length() > 1) {
				temp = temp.substring(0,1);
				//temporary band-aid here for low quality data in db
			}

			int levelCheck = Integer.parseInt(temp);
			System.out.println(levelCheck);
			if(levelCheck <= viewCharacter.getAerotheurge_level()) {
				spells2Page.add(spellsToAdd.get(i));
			}
			System.out.println(i);
			i++;
		}
		
		System.out.println(spells2Page);
		model.addAttribute("spellsCharacterCanLearn", spells2Page);
		
		
		System.out.println(spellLevel);
		
		
		System.out.println(spellsToAdd.get(0).getRequiredLevel());
//		actionPointsString = actionPointsString.substring(startIndex + 1, endIndex);
		
		
		return "viewCharacter.jsp";
	}
	
}
