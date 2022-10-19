package com.jpaCountry.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.swing.plaf.synth.Region;



@Entity 
@Table(name="countries")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable=true)
	private String country_code2;
	@Column(nullable=true)
	private String country_code3;
	
	private String name;
	private Date national_day;
	@Column(nullable=true)
	private java.math.BigDecimal area;
	
	@ManyToOne 
	@JoinColumn(name="region_id", nullable=true) //Foreign Key
	private Region region;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry_code2() {
		return country_code2;
	}

	public void setCountry_code2(String country_code2) {
		this.country_code2 = country_code2;
	}

	public String getCountry_code3() {
		return country_code3;
	}

	public void setCountry_code3(String country_code3) {
		this.country_code3 = country_code3;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getNational_day() {
		return national_day;
	}

	public void setNational_day(Date national_day) {
		this.national_day = national_day;
	}

	public java.math.BigDecimal getArea() {
		return area;
	}

	public void setArea(java.math.BigDecimal area) {
		this.area = area;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}












	
}



