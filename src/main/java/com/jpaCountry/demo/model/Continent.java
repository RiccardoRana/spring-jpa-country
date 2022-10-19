package com.jpaCountry.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="continents")
public class Continent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="name",nullable=true)
	private String nameContinent;
	
	@OneToMany(mappedBy="continent")
	@OrderBy("region_id")
	private List<Regione> regions;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameContinent() {
		return nameContinent;
	}

	public void setNameContinent(String nameContinent) {
		this.nameContinent = nameContinent;
	}

	public List<Regione> getRegions() {
		return regions;
	}

	public void setRegions(List<Regione> regions) {
		this.regions = regions;
	} 








}
