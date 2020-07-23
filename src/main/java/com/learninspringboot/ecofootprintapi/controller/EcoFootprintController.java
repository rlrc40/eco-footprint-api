package com.learninspringboot.ecofootprintapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learninspringboot.ecofootprintapi.model.EcoFootprint;
import com.learninspringboot.ecofootprintapi.service.EcoFootprintService;

@RestController
@RequestMapping("/eco-footprints")
public class EcoFootprintController {
	  
	
	@Autowired
	private EcoFootprintService service;
	
	@GetMapping("/list")
	public List<EcoFootprint> listFootprints() {
		return service.listFootprints();
	}
	
	@GetMapping(value = "/{id}")
	public Optional<EcoFootprint> getFootprintById(@PathVariable("id") String id) {
		return service.getFootprintById(id);
	}
	
	@PostMapping
	public EcoFootprint createFootprint(@RequestBody EcoFootprint footprint) {
		return service.createFootprint(footprint);
	}
	
	@PutMapping
	public EcoFootprint updateFootprint(@RequestBody EcoFootprint footprint) {
		return service.updateFootprint(footprint);
	}
	
	@DeleteMapping(value = "/{id}")
	public String deleteFootprint(@PathVariable("id") String id) {
		return service.deleteFootprint(id);
	}
}
