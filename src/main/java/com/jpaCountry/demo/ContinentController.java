package com.jpaCountry.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jpaCountry.demo.model.Continent;
import com.jpaCountry.demo.repository.ContinentRepository;



@RestController
@RequestMapping("/continent")
public class ContinentController {

	
	private ContinentRepository continentRepository;
	
	@GetMapping("/continents")
	public List<Continent> getContinents(){
		return (List<Continent>) continentRepository.findAll();
	}
	
	@GetMapping("/continentcode/{continentId}")  //GET /api/country/3
	public Continent getContinentById(@PathVariable(value = "continentId") int continentId) {
		Optional<Continent> cont=continentRepository.findById(continentId);
		if (cont.isPresent())
			return cont.get();		//ritorno l'istanza di country
		else
			return new Continent(); //ritorno l'oggetto vuoto
	}

	
	


}
