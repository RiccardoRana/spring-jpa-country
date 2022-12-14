package com.jpaCountry.demo.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="regions")
public class Regione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="region_id")
	private int id;
	
	@Column(name="name",nullable=true)
	private String nameRegion;
	
	@ManyToOne
	@JoinColumn(name="continent_id", nullable=false) //Foreign Key
	@JsonBackReference
	private Continent continent;
	
	@OneToMany(mappedBy="region")
	@OrderBy("country_id")
	private List<Country> countries;

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameRegion() {
		return nameRegion;
	}

	public void setNameRegion(String nameRegion) {
		this.nameRegion = nameRegion;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	} 
	
	












}
