package com.jpaCountry.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jpaCountry.demo.model.Country;
import com.jpaCountry.demo.model.Regione;
import com.jpaCountry.demo.repository.CountryRepository;
import com.jpaCountry.demo.repository.RegionRepository;

@RestController
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private RegionRepository regionRepository;

	@GetMapping("/countries")
	public List<Country> getCountries() {
		return (List<Country>) countryRepository.findAll();
	}

	//CountryById
	@GetMapping("/countrycode/{countryId}") // GET /api/country/3
	public ResponseEntity<Country> getCountryById(@PathVariable(value = "countryId") int countryId) {
		Optional<Country> countr = countryRepository.findById(countryId);
		if (countr.isPresent())
			return  new ResponseEntity<Country> (countr.get(), HttpStatus.OK); // ritorno l'istanza di country
		else
			return new ResponseEntity<Country> ((Country)null,HttpStatus.NOT_FOUND); // ritorno l'oggetto vuoto
	}

	@GetMapping("/countrybyregion") // GET /country/countrybyregion?regionId=1
	public List<Country> getCountryByRegion(@RequestParam(value = "regionId") Integer regionId) {
		if (regionId == 0)
			return (List<Country>) countryRepository.findAll();
		else
			return (List<Country>) countryRepository.findByRegion(regionId);
	}

	// Nuova Nazione:
	@PostMapping(value = "/newcountry/{regionId}") // POST /api/students
	public ResponseEntity<Country> createStudent(@PathVariable(value="regionId") int regionId,@RequestBody Country country) {
		Optional<Regione> region = regionRepository.findById(regionId);
		if (region.isPresent()) {
			country.setRegion(region.get());
			return new ResponseEntity<Country>(countryRepository.save(country), HttpStatus.CREATED);
		}
		else 
			return new ResponseEntity<Country>((Country) null, HttpStatus.NOT_FOUND);
	}

	// Eliminare una nazione:
	@DeleteMapping(value = "/deletecountry/{countryId}")
	public void deleteCountry(@PathVariable(value = "countryId") int countryId) {
		countryRepository.deleteById(countryId);
	}

	//Modifica Nazione
	@PutMapping(value = "/countries/{countryId}")
	public ResponseEntity<Country> updateCountry(@PathVariable(value = "countryId") int countryId,
			@RequestBody Country country) {
		Optional<Country> s = countryRepository.findById(countryId);
		if (s.isPresent()) {
			Country s1 = s.get();
			s1.setName(country.getName());
			s1.setCountry_code2(country.getCountry_code2());
			s1.setCountry_code3(country.getCountry_code3());
			s1.setArea(country.getArea());
            return new ResponseEntity<Country>(countryRepository.save(s1), HttpStatus.OK);
		} else
			return new ResponseEntity<Country>((Country) null, HttpStatus.NOT_FOUND);

	}
}
