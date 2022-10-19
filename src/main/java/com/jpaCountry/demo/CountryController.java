package com.jpaCountry.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jpaCountry.demo.model.Country;
import com.jpaCountry.demo.repository.CountryRepository;

@RestController
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private CountryRepository countryRepository;
	
	@GetMapping("/countries")
	public List<Country> getCountries(){
		return (List<Country>)countryRepository.findAll();
	}

	@GetMapping("/countrycode/{countryId}")  //GET /api/country/3
	public Country getCountryById(@PathVariable(value = "countryId") int countryId) {
		Optional<Country> countr=countryRepository.findById(countryId);
		if (countr.isPresent())
			return countr.get();		//ritorno l'istanza di country
		else
			return new Country(); //ritorno l'oggetto vuoto
	}

	@GetMapping("/countrybyregion")  //GET /country/countrybyregion?regionId=1
	public List<Country> getCountryByRegion(@PathVariable(value = "regionId") int regionId) {
		if (regionId == 0)
			return (List<Country>)countryRepository.findAll();
		else 
			return (List <Country>)countryRepository.findByRegion(regionId);
	}


    




}
