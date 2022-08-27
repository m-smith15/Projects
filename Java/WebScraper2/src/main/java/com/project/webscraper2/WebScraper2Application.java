package com.project.webscraper2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomText;
import com.gargoylesoftware.htmlunit.html.HtmlPage;



@SpringBootApplication
public class WebScraper2Application implements CommandLineRunner {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	WebClient webClient = new WebClient();
	HtmlPage page;
	
	public static void main(String[] args) {
		SpringApplication.run(WebScraper2Application.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception{
		WebScraper scraper = WebScraper.scraper();
		System.out.println(scraper + " scraper");
		page = scraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/All+Skills");
		
		//building list of schools based on all skills page
		List<DomText> schools = page.getByXPath("//h3/a/text()");
		System.out.println("Spell schools query results");
		System.out.println(schools);
		
		//creating empty list of schools to add to based off whats in the HTML 
		List<String> listofschools = new ArrayList<>();

		//validations, adding to list
		for (DomText domText: schools) {
		String text = domText.toString();
			if(text != null && text.length() > 0) {
				listofschools.add(text);
			}
		}
		//start at 0
		int i = 0;
		//listofschools.size()
		while(i < listofschools.size()) {
			List<String> listofspells = new ArrayList<>();
		
			//start scraping specific school pages for spells
			WebScraper spellScraper = new WebScraper("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills");
			//System.out.println(spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+schools.get(0)+"+Skills"));
			
			System.out.println("--testing--");
			List<DomText> spellsonPage = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//table/tbody/tr");
			
			int x = 1;
			while(x < (spellsonPage.size())){
				
				//creating a runner var to help maneuver due to table structure differing between rows and tables
				int xPlus1 = x + 1;
				
				System.out.println("---School---");
				String schoolString = listofschools.get(i);
				
				System.out.println("---Name---");
				List<DomText> spellName = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+x+"]/td[1]/h4/a/text()");
				String nameString = spellName.toString();
				//geo table structure
				if(listofschools.get(i) == listofschools.get(1)) {
					nameString = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+x+"]/td[1]/th/h5/a/text()").toString();
					if(nameString == "[]") {
						nameString = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+x+"]/th/h4/a/text()").toString();
					}
				}
				//scoundrel specific
				if(listofschools.get(i) == listofschools.get(7)) {
					nameString = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+x+"]/th/h4/a/text()").toString();
				}
				//use of h4 or h5 tags differs from row to row and page to page
				if(nameString == "[]") {
					nameString = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+x+"]/td[1]/h5/a/text()").toString();
					if(nameString == "[]") {
						nameString = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+x+"]/th/h5/a/text()").toString();
					}
				}
				listofspells.add(nameString);
				
				System.out.println("---Description---");
				List<DomText> description = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+x+"]/td[2]/p/text()");
				String descriptionString = description.toString();
				//accounting for Geo
				if(descriptionString == "[]") {
					descriptionString = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+x+"]/td/text()").toString();
				}
				//scoundrel specific
				if(descriptionString == "[]") {
					descriptionString = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+x+"]/td[2]//text()").toString();
				}
				//sql limit on string (varchar) is 255 - cutting it off if it reaches that
				if(descriptionString.length() > 255) {
					descriptionString = descriptionString.substring(0 , 255);
				}
				listofspells.add(descriptionString);
				
				System.out.println("---Required Level---");
				List<DomText> reqLevel = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+xPlus1+"]/td[1]/text()");
				String reqLevelString = reqLevel.toString();
				//account for Geo
				if(reqLevelString == "[]") {
					reqLevelString = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+xPlus1+"]/th/text()").toString();
				}
				listofspells.add(reqLevelString);
				
				System.out.println("---Memory Slot---");
				List<DomText> memorySlots = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+xPlus1+"]/td[2]/text()");
				String memorySlotsString = memorySlots.toString();
				//scoundrel table
				if(memorySlotsString == "[]") {
					memorySlotsString = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+xPlus1+"]/td[1]/text()").toString();
				}
				listofspells.add(memorySlotsString);
				
				System.out.println("---AP---");														//"//tbody/tr[4]/td[3]/img/@alt"		// first in aero is hyperlinked "//tbody/tr[4]/td[3]/a/img/@alt"
				String actionPointsString = "";
				//the first item in aero is hyperlinked....accounting for that. Revisit this later probably a better way to approach this.
				if(listofschools.get(i) == listofschools.get(0) && x == 1) {
					List<DomText> actionPoints = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+xPlus1+"]/td[3]/a/img/@src");	
					actionPointsString = actionPoints.toString();
					int startIndex = actionPointsString.indexOf("/AP");
					int endIndex = actionPointsString.indexOf(".png");
					System.out.println("its aerothurge " + actionPointsString + " | " + startIndex + " | " + endIndex + " | " + listofschools.get(i).toString() + " | " + x);
					actionPointsString = actionPointsString.substring(startIndex + 1, endIndex);
					System.out.println(actionPointsString);
						if(actionPointsString.length() == 2) {
							actionPointsString = "AP1";
						}
						listofspells.add(actionPointsString);
				} 
				else {
					List<DomText> actionPoints = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+xPlus1+"]/td[3]/img/@src");
					actionPointsString = actionPoints.toString();
					//Geo...
					if(actionPointsString == "[]") {
						actionPointsString = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+xPlus1+"]/td[2]/img/@src").toString();
					}
					int startIndex = actionPointsString.indexOf("/AP");
					int endIndex = actionPointsString.indexOf(".png");
					System.out.println("its NOT aerothurge " + actionPointsString + " | " + startIndex + " | " + endIndex + " | " + listofschools.get(i).toString() + " | " + x);
					if(actionPointsString == "[]") {
						actionPointsString = "AP0";
					} else {
						actionPointsString = actionPointsString.substring(startIndex + 1, endIndex);
					}
					System.out.println(actionPointsString);
						if(actionPointsString.length() == 2) {
							actionPointsString = "AP1";
						}
						listofspells.add(actionPointsString);
				}
				
				System.out.println("---SP---");
				List<DomText> sourcePoints = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+xPlus1+"]/td[4]/text()");
				String sourcePointsString = sourcePoints.toString();
				//geo..
				if(sourcePointsString == "[]"){
					sourcePointsString = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+xPlus1+"]/td[3]/text()").toString();
				}
				if(sourcePointsString.contains("-")){
					sourcePointsString = "0";
				}
				//scoundrel...
				if(sourcePointsString == "[]") {
					sourcePointsString = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+xPlus1+"]/td[4]/img/@src").toString();
					int startIndex = sourcePointsString.indexOf("/SP");
					int endIndex = sourcePointsString.indexOf(".png");
					sourcePointsString = sourcePointsString.substring(startIndex + 1, endIndex);
					if(actionPointsString == "SP") {
						actionPointsString = "SP1";
					}
				}
				listofspells.add(sourcePointsString);
				
				System.out.println("---Cooldown---");
				List<DomText> cooldown = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+xPlus1+"]/td[5]/text()");
				String cooldownString = cooldown.toString();
				listofspells.add(cooldownString);
				
				System.out.println("---Resist---");
				List<DomText> resistance = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+xPlus1+"]/td[6]/text()");
				String resistanceString = resistance.toString();
				if(resistanceString.contains("-")){
					resistanceString = "0";
				}
				if(resistanceString == "[]") {
					resistanceString = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+xPlus1+"]/td[6]/img/@alt").toString();
					int startIndex = resistanceString.indexOf("value=");
					int endIndex = resistanceString.indexOf("]]");
						//geo check
						if(resistanceString == "[]") {
							resistanceString = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+xPlus1+"]/td[6]/img/@src").toString();
							startIndex = resistanceString.indexOf("Sin-2/");
							endIndex = resistanceString.indexOf(".png");
						}
					resistanceString = resistanceString.substring(startIndex + 6, endIndex);
					//armor type check
						if(resistanceString.contains("magic")) {
							resistanceString = "Magic Armor";
						} else {
							resistanceString = "Physical Armor";
						}
				}
				listofspells.add(resistanceString);
				
				System.out.println("---Scale---");
				List<DomText> scale = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+xPlus1+"]/td[7]/text()");
				String scaleString = scale.toString();
				if(scaleString.contains("-")){
					scaleString = "n/a";
				}
				listofspells.add(scaleString);
				
				System.out.println("---Range---");
				List<DomText> range = spellScraper.getWebPage("https://divinityoriginalsin2.wiki.fextralife.com/"+listofschools.get(i)+"+Skills").getByXPath("//tbody/tr["+xPlus1+"]/td[8]/text()");
				String rangeString = range.toString();
				if(rangeString == "--") {
					rangeString = "0";
				}
				listofspells.add(rangeString);
				
			//note to self - leaving these in for debugging if needed later. Def wondering if I need them at all anymore. 
			
			
//			System.out.println(nameString);
//			System.out.println(descriptionString);
//			System.out.println(reqLevelString);
//			System.out.println(memorySlotsString);
//			System.out.println(listofspells.get(4));
//			System.out.println(sourcePointsString);
//			System.out.println(cooldownString);
//			System.out.println(resistanceString);
//			System.out.println(scaleString);
//			System.out.println(range);
			String replaceThis = (listofspells.get(4)).toString();
//			//System.out.println(spellsonPage.size() / 2);
//			
//			System.out.println(i);
//			System.out.println(listofspells);
//			System.out.println(listofschools.get(i));
			//createSpell(nameString, descriptionString, reqLevelString, memorySlotsString, replaceThis, sourcePointsString, cooldownString, resistanceString, scaleString, rangeString);
			System.out.println("incrementing x from"+x+ " to " + x+2 +"");
			x = x + 2;
			String apString = listofspells.get(4);
			//Spell spellToBeSaved = new Spell(nameString, descriptionString, reqLevelString, memorySlotsString, apString, sourcePointsString, cooldownString, resistanceString, scaleString, rangeString);
			//webScraperService.saveSpell(spellToBeSaved);
			
			//(nameString, descriptionString, reqLevelString, memorySlotsString, rangeString, sourcePointsString, cooldownString, resistanceString, scaleString, apString);
			String sql = "INSERT INTO spells (school, name, description, required_level, memory_slots, action_points, source_points, cooldown, resist, scale, area) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			//System.out.println(sql);
			System.out.println("Attempting to add " + nameString);
			int result = jdbcTemplate.update(sql, schoolString, nameString, descriptionString, reqLevelString, memorySlotsString, actionPointsString, sourcePointsString, cooldownString, resistanceString, scaleString, rangeString);
			
			if(result > 0) {
				System.out.println("new row was inserted!!");
			}
		}
		System.out.println("incrementing i from " + i + "to " + i+1 + "");
		i++;
	}
			
	}

}

