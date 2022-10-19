package com.jpaCountry.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.jpaCountry.demo.model.Continent;

public interface ContinentRepository extends CrudRepository<Continent, Integer>{

}
