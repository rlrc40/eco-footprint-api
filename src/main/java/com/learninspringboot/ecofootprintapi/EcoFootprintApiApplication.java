package com.learninspringboot.ecofootprintapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learninspringboot.ecofootprintapi.model.EcoFootprint;
import com.learninspringboot.ecofootprintapi.repo.EcoFootprintRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class EcoFootprintApiApplication implements CommandLineRunner {

	@Autowired
	private EcoFootprintRepo repo;
  
	private static Logger LOG = LoggerFactory.getLogger(EcoFootprintApiApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(EcoFootprintApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Logging from application...");
		LOG.warn("Warning from application...");
		
		repo.deleteAll();

	    // save a couple of footprints
	    repo.save(new EcoFootprint("Alice", "Smith", "1"));
	    repo.save(new EcoFootprint("Bob", "Smith", "2"));

	    // fetch all footprints
	    LOG.info("Customers found with findAll():");
	    LOG.info("-------------------------------");
	    for (EcoFootprint ecoFootprint : repo.findAll()) {
	      LOG.info("" + ecoFootprint);
	    }

	    // fetch an individual footprint
	    LOG.info("Footprint found with findByFirstName('Alice'):");
	    LOG.info("--------------------------------");
	    LOG.info("" + repo.findByFirstName("Alice"));

	    LOG.info("Footprints found with findByLastName('Smith'):");
	    LOG.info("--------------------------------");
	    for (EcoFootprint ecoFootprint : repo.findByLastName("Smith")) {
	      LOG.info("" + ecoFootprint);
	    }
	}

}
