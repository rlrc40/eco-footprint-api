package com.learninspringboot.ecofootprintapi.service;

import com.learninspringboot.ecofootprintapi.controller.EcoActionController;
import com.learninspringboot.ecofootprintapi.model.EcoAction;
import com.learninspringboot.ecofootprintapi.repo.EcoActionRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class EcoActionService {
	  
	private static Logger LOG = LoggerFactory.getLogger(EcoActionController.class);

	@Autowired
	private EcoActionRepo repo;
	
	public List<EcoAction> listEcoActions() {
		LOG.info("GET ALL ECOACTIONS");
		return repo.findAll();
	}
	
	public Optional<EcoAction> getEcoActionById(@PathVariable("id") String id) {
		LOG.info("GET ECOACTION WITH ID: " + id);
		return repo.findById(id);
	}
	
}
