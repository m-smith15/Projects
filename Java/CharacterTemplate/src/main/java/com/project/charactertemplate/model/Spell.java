package com.project.charactertemplate.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="spells")
public class Spell {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="name is required!")
	@Size(min=2, max=255)
	private String name;
	
	@NotEmpty(message="description is required!")
	@Size(min=2, max=255)
	private String description;
	
	@NotEmpty(message="requiredLevel is required!")
	@Size(min=2, max=255)
	private String requiredLevel;
	
	@NotEmpty(message="memorySlots is required!")
	@Size(min=2, max=255)
	private String memorySlots;
	
	@NotEmpty(message="actionPoints is required!")
	@Size(min=2, max=255)
	private String actionPoints;
	
	@NotEmpty(message="sourcePoints is required!")
	@Size(min=2, max=255)
	private String sourcePoints;
	
	@NotEmpty(message="cooldown is required!")
	@Size(min=2, max=255)
	private String cooldown;
	
	@NotEmpty(message="resist is required!")
	@Size(min=2, max=255)
	private String resist;
	
	@NotEmpty(message="scale is required!")
	@Size(min=2, max=255)
	private String scale;
	
	@NotEmpty(message="area is required!")
	@Size(min=2, max=255)
	private String area;
	
	@NotEmpty(message="school is required!")
	@Size(min=2, max=255)
	private String school;
	
//	@OneToMany(mappedBy="spell")
//	private List<AerotheurgeSpell> aerotheurgeSpells;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="character_id")
	private CharacterTemplate characterTemplate;
	
	//constructor
	
	public Spell() {}
	
	public Spell(String name, String description, String requiredLevel, String memorySlots,
			String actionPoints, String sourcePoints, String cooldown, String resist, String scale,
			String area, String school) {
		
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
		this.school = school;
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

	public void setArea(String area) {
		this.area = area;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public CharacterTemplate getCharacterTemplate() {
		return characterTemplate;
	}

	public void setCharacterTemplate(CharacterTemplate characterTemplate) {
		this.characterTemplate = characterTemplate;
	}
    
    
}
