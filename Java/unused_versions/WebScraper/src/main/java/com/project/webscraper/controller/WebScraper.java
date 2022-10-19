package com.project.webscraper.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.jdbc.core.JdbcTemplate;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomText;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.project.webscraper.model.Spell;
import com.project.webscraper.service.WebScraperService;

//
//@SpringBootApplication
@Controller
public class WebScraper {
	
	@Autowired
	private WebScraperService webScraperService;
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
//	public static void main(String[] args) throws IOException{
//		SpringApplication.run(WebScraper.class, args);
//	}

//	@Override
//	public void run(String... args) throws Exception {
//		String sql = "INSERT INTO spells (name, description, requiredLevel, memorySlots, actionPoints, cooldown, resist, scale, area) VALUES (test,test,test,test,test,test,test,test,test)";
//		
//		int result = jdbcTemplate.update(sql, "name", "description", "requiredLevel", "memorySlots", "actionPoints", "cooldown", "resist", "scale", "area");
//		
//		if(result > 0) {
//			System.out.println("new row was inserted!!");
//		}
//	}
	
	public static void scraper() throws IOException {
		WebScraper webScraper = new WebScraper("https://divinityoriginalsin2.wiki.fextralife.com/All+Skills");
		//System.out.println("hello");
		System.out.println(webScraper.extractInformation());
	}
	
	WebClient webClient = new WebClient();
	HtmlPage page;
	
	//constructor and getting page url
	public WebScraper(String url) throws IOException {
		//"https://divinityoriginalsin2.wiki.fextralife.com/All+Skills";
		page = getWebPage(url);
	}
	
	//setting options - no need for css or js
	private HtmlPage getWebPage(String url) throws IOException {
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setJavaScriptEnabled(false);
		//return page in plain HTML
		return webClient.getPage(url);
	}
	
	
	public List<String> extractInformation() throws IOException{
		
		//XPath is the path to where the element(s) are located in the HTML page that we are looking at
		List<DomText> schools = page.getByXPath("//h3/a/text()");
		//System.out.println(schools.size());
		System.out.println("Spell schools query results");
		System.out.println(schools);
		
		//List<DomText> spells = page.getByXPath("//*[@class='wiki_link wiki_tooltip']/text()");
		
		//System.out.println("Spell query results");
//		System.out.println(spells);
		
		
		//creating empty list of schools to add to based off whats in the HTML 
		List<String> listofschools = new ArrayList<>();
		
		
		

		//validations, adding to list
		for (DomText domText: schools) {
		String text = domText.toString();
		
			if(text != null && text.length() > 0) {
				listofschools.add(text);
			}
		}
		int i = 0;
		int x = 1;
		int runner = 1;
		//listofschools.size() / 2
		while(i < 1) {
			List<String> listofspells = new ArrayList<>();
		
			//start scraping specific school pages for spells
			WebScraper spellScraper = new WebScraper("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills");
			//System.out.println(spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+schools.get(0)+"+Skills"));
			
			System.out.println("---Name---");
			List<DomText> spellName = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+x+"]/td[1]/h4/a/text()");
			String nameString = spellName.toString();
			listofspells.add(nameString);
			
			System.out.println("---Description---");
			List<DomText> description = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+x+"]/td[2]/p/text()");
			String descriptionString = description.toString();
			listofspells.add(descriptionString);
			
			System.out.println("---Required Level---");
			List<DomText> reqLevel = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+(x+1)+"]/td[1]/text()");
			String reqLevelString = schools.get(i) + reqLevel.toString();
			listofspells.add(reqLevelString);
			
			System.out.println("---Memory Slot---");
			List<DomText> memorySlots = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+(x+1)+"]/td[2]/text()");
			String memorySlotsString = memorySlots.toString();
			listofspells.add(memorySlotsString);
			
			System.out.println("---AP---");																//"//tbody/tr[4]/td[3]/img/@alt"		// first in aero is hyperlinked "//tbody/tr[4]/td[3]/a/img/@alt"
			if(listofschools.get(i) == "Aerothurge" && i == 1) {
				List<DomText> actionPoints = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+(x+1)+"]/td[3]/a/img/@alt");	
				String toBeReplaced = actionPoints.toString();
//				int startIndex = toBeReplaced.indexOf("value=");
//				int endIndex = toBeReplaced.indexOf("]]");
//				String actionPointsString = toBeReplaced.substring(startIndex + 6, endIndex);
				if(toBeReplaced.length() < 3) {
					toBeReplaced = "AP1";
				}
				listofspells.add(toBeReplaced);
			} 
			else {
				List<DomText> actionPoints = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+(x+1)+"]/td[3]/img/@alt");
				String toBeReplaced = actionPoints.toString();
//				int startIndex = toBeReplaced.indexOf("value=");
//				int endIndex = toBeReplaced.indexOf("]]");
//				String actionPointsString = toBeReplaced.substring(startIndex + 6, endIndex);
				if(toBeReplaced.length() < 3) {
					toBeReplaced = "AP1";
				}
				listofspells.add(toBeReplaced);
			}
			
			System.out.println("---SP---");
			List<DomText> sourcePoints = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+(x+1)+"]/td[4]/text()");
			String sourcePointsString = sourcePoints.toString();
			if(sourcePointsString.contains("-")){
				sourcePointsString = "0";
			}
			listofspells.add(sourcePointsString);
			
			System.out.println("---Cooldown---");
			List<DomText> cooldown = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+(x+1)+"]/td[5]/text()");
			String cooldownString = cooldown.toString();
			listofspells.add(cooldownString);
			
			System.out.println("---Resist---");
			List<DomText> resistance = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+(x+1)+"]/td[6]/text()");
			String resistanceString = resistance.toString();
			if(resistanceString.contains("-")){
				resistanceString = "0";
			}
			listofspells.add(resistanceString);
			
			System.out.println("---Scale---");
			List<DomText> scale = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+(x+1)+"]/td[7]/text()");
			String scaleString = scale.toString();
			if(scaleString.contains("-")){
				scaleString = "n/a";
			}
			listofspells.add(scaleString);
			
			System.out.println("---Range---");
			List<DomText> range = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+(x+1)+"]/td[8]/text()");
			String rangeString = range.toString();
			if(rangeString == "--") {
				rangeString = "0";
			}
			listofspells.add(rangeString);
			
//			System.out.println("--testing--");
//			List<DomText> spellsonPage = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+schools.get(i)+"+Skills").getByXPath("//table/tbody/tr");
			
			//page.getByXPath("//tbody/tr[1]/td[1]/text()");
			
			
			System.out.println(nameString);
			System.out.println(descriptionString);
			System.out.println(reqLevelString);
			System.out.println(memorySlotsString);
			System.out.println(listofspells.get(4));
			System.out.println(sourcePointsString);
			System.out.println(cooldownString);
			System.out.println(resistanceString);
			System.out.println(scaleString);
			System.out.println(range);
			//System.out.println(spellsonPage.size() / 2);
			
			System.out.println(i);
			System.out.println(listofspells);
			System.out.println(listofschools.get(i));
			i++;
			x = x + 2;
			String apString = listofspells.get(5);
			Spell spellToBeSaved = new Spell(nameString, descriptionString, reqLevelString, memorySlotsString, apString, sourcePointsString, cooldownString, resistanceString, scaleString, rangeString);
			//webScraperService.saveSpell(spellToBeSaved);
		}
			
		return listofschools;
	}
	
}
