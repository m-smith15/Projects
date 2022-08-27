package com.project.charactertemplate.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="characters")
public class CharacterTemplate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Name is required)")
	@Size(min=2, max = 255)
	private String name;
	
	@Min(0)
	private int aerotheurge_level;
	
	@Min(0)
	private int geomancer_level;
	
	@Min(0)
	private int huntsman_level;
	
	@Min(0)
	private int hydrosophist_level;
	
	@Min(0)
	private int necromancer_level;

	@Min(0)
	private int polymorph_level;

	@Min(0)
	private int pyrokinetic_level;

	@Min(0)
	private int scoundrel_level;

	@Min(0)
	private int summoning_level;

	@Min(0)
	private int warfare_level;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@OneToMany(mappedBy="characterTemplate")
	private List<Spell> spells;
	
	
	public CharacterTemplate() {}
	
	public CharacterTemplate(String name, int aerotheurge_level, int geomancer_level, int huntsman_level,
			int hydrosophist_level, int necromancer_level, int polymorph_level, int pyrokinetic_level, int scoundrel_level,
			int summoning_level, int warfare_level) {
		
		this.name = name;
		this.aerotheurge_level = aerotheurge_level;
		this.geomancer_level = geomancer_level;
		this.huntsman_level = huntsman_level; 
		this.hydrosophist_level = hydrosophist_level;
		this.necromancer_level = necromancer_level;
		this.polymorph_level = polymorph_level;
		this.pyrokinetic_level = pyrokinetic_level;
		this.scoundrel_level = scoundrel_level;
		this.summoning_level = summoning_level;
		this.warfare_level = warfare_level;
	}
	
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Spell> getSpells() {
		return spells;
	}

	public void setSpells(List<Spell> spells) {
		this.spells = spells;
	}

	public int getAerotheurge_level() {
		return aerotheurge_level;
	}

	public void setAerotheurge_level(int aerotheurge_level) {
		this.aerotheurge_level = aerotheurge_level;
	}

	public int getGeomancer_level() {
		return geomancer_level;
	}

	public void setGeomancer_level(int geomancer_level) {
		this.geomancer_level = geomancer_level;
	}

	public int getHuntsman_level() {
		return huntsman_level;
	}

	public void setHuntsman_level(int huntsman_level) {
		this.huntsman_level = huntsman_level;
	}

	public int getHydrosophist_level() {
		return hydrosophist_level;
	}

	public void setHydrosophist_level(int hydrosophist_level) {
		this.hydrosophist_level = hydrosophist_level;
	}

	public int getNecromancer_level() {
		return necromancer_level;
	}

	public void setNecromancer_level(int necromancer_level) {
		this.necromancer_level = necromancer_level;
	}

	public int getPolymorph_level() {
		return polymorph_level;
	}

	public void setPolymorph_level(int polymorph_level) {
		this.polymorph_level = polymorph_level;
	}

	public int getPyrokinetic_level() {
		return pyrokinetic_level;
	}

	public void setPyrokinetic_level(int pyrokinetic_level) {
		this.pyrokinetic_level = pyrokinetic_level;
	}

	public int getScoundrel_level() {
		return scoundrel_level;
	}

	public void setScoundrel_level(int scoundrel_level) {
		this.scoundrel_level = scoundrel_level;
	}

	public int getSummoning_level() {
		return summoning_level;
	}

	public void setSummoning_level(int summoning_level) {
		this.summoning_level = summoning_level;
	}

	public int getWarfare_level() {
		return warfare_level;
	}

	public void setWarfare_level(int warfare_level) {
		this.warfare_level = warfare_level;
	}

}
