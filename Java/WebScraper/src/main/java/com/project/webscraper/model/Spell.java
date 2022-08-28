package com.project.webscraper.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="spells")
public class Spell {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String requiredLevel;
	private String memorySlots;
	private String actionPoints;
	private String sourcePoints;
	private String cooldown;
	private String resist;
	private String scale;
	private String area;
	
	//add m2m table joining to school here
	
	public Spell() {}
	
	public Spell(String name, String description, String requiredLevel, String memorySlots,
				String actionPoints, String sourcePoints, String cooldown, String resist, String scale,
				String area) {
		this.name = name;
		this.description = description;
		this.requiredLevel = requiredLevel;
		this.memorySlots = memorySlots;
		this.actionPoints = actionPoints;
		this.sourcePoints = sourcePoints;
		this.cooldown = cooldown;
		this.resist = resist;
		this.scale = scale;
		this.area = area;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequiredLevel() {
		return requiredLevel;
	}

	public void setRequiredLevel(String requiredLevel) {
		this.requiredLevel = requiredLevel;
	}

	public String getMemorySlots() {
		return memorySlots;
	}

	public void setMemorySlots(String memorySlots) {
		this.memorySlots = memorySlots;
	}

	public String getActionPoints() {
		return actionPoints;
	}

	public void setActionPoints(String actionPoints) {
		this.actionPoints = actionPoints;
	}

	public String getSourcePoints() {
		return sourcePoints;
	}

	public void setSourcePoints(String sourcePoints) {
		this.sourcePoints = sourcePoints;
	}

	public String getCooldown() {
		return cooldown;
	}

	public void setCooldown(String cooldown) {
		this.cooldown = cooldown;
	}

	public String getResist() {
		return resist;
	}

	public void setResist(String resist) {
		this.resist = resist;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getArea() {
		return area;
	}

	public void setRange(String area) {
		this.area = area;
	}
	
	
}
