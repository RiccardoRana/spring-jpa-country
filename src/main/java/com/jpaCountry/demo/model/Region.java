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
import javax.persistence.Table;


@Entity
@Table(name="regions")
public class Region {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name",nullable=true)
	private String nameRegion;
	
	@ManyToOne
	@JoinColumn(name="continent_id", nullable=true) //Foreign Key
	private Continent continent;
	
	@OneToMany(mappedBy="region")
	private List<Country> countries; 
	
	












}
