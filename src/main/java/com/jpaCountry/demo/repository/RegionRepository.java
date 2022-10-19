package com.jpaCountry.demo.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.jpaCountry.demo.model.Regione;

public interface RegionRepository extends CrudRepository<Regione, Integer> {

	public List<Regione> findByContinent(int continentId);

}
