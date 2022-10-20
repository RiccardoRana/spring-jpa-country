package com.jpaCountry.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jpaCountry.demo.model.Regione;
import com.jpaCountry.demo.repository.RegionRepository;

@RestController
@RequestMapping("/region")
public class RegionController {


	@Autowired
	private RegionRepository regionRepository;

	@GetMapping("/regions")
	public List<Regione> getRegions(){
		return (List<Regione>)regionRepository.findAll();
	}
	
	@GetMapping("/regioncode/{regionId}")  //GET /api/country/3
	public Regione getCountryById(@PathVariable(value = "regionId") int regionId) {
		Optional<Regione> reg=regionRepository.findById(regionId);
		if (reg.isPresent())
			return reg.get();		//ritorno l'istanza di country
		else
			return new Regione(); //ritorno l'oggetto vuoto
	}

	@GetMapping("/regionbycontinent")  //GET /country/regionbycontinent?continentId=1
	public List<Regione> getCountryByRegion(@PathVariable(value = "continentId") Integer continentId) {
		if (continentId == 0)
			return (List<Regione>)regionRepository.findAll();
		else 
			return (List <Regione>)regionRepository.findByContinent(continentId);
	}








}
