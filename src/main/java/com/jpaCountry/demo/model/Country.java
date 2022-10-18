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












	
}



