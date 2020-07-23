package com.learninspringboot.ecofootprintapi.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.learninspringboot.ecofootprintapi.controller.EcoFootprintController;
import com.learninspringboot.ecofootprintapi.model.EcoFootprint;
import com.learninspringboot.ecofootprintapi.repo.EcoFootprintRepo;

@Service
public class EcoFootprintService {
	  
	private static Logger LOG = LoggerFactory.getLogger(EcoFootprintController.class);

	@Autowired
	private EcoFootprintRepo repo;
	
	public List<EcoFootprint> listFootprints() {
		LOG.info("GET ALL ECOFOOTPRINTS");
		return repo.findAll();
	}
	
	public Optional<EcoFootprint> getFootprintById(@PathVariable("id") String id) {
		LOG.info("GET ECOFOOTPRINT WITH ID: " + id);
		return repo.findById(id);
	}
	
	public EcoFootprint createFootprint(@RequestBody EcoFootprint footprint) {
		footprint.setFootprintId(UUID.randomUUID().toString());
		LOG.info("CREATE ECOFOOTPRINT: " + footprint.toString());
		return repo.save(footprint);
	}
	
	public EcoFootprint updateFootprint(@RequestBody EcoFootprint footprint) {
		LOG.info("UPDATE ECOFOOTPRINT: " + footprint.toString());
		return repo.save(footprint);
	}
	
	public String deleteFootprint(@PathVariable("id") String id) {
		LOG.info("DELETE ECOFOOTPRINT WITH ID: " + id);
		repo.deleteById(id);
		return id;
	}
	
}
