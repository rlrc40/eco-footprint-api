package com.learninspringboot.ecofootprintapi.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learninspringboot.ecofootprintapi.model.EcoFootprint;

public interface EcoFootprintRepo extends MongoRepository<EcoFootprint, String> {

	  public EcoFootprint findByFirstName(String firstName);
	  public List<EcoFootprint> findByLastName(String lastName);

}
