package com.jpaCountry.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jpaCountry.demo.model.Country;

public interface CountryRepository extends CrudRepository<Country, Integer> {

	public List<Country> findByRegion(int regionId);

}
