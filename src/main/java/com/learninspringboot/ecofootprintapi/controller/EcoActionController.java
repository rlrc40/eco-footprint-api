package com.learninspringboot.ecofootprintapi.controller;

import com.learninspringboot.ecofootprintapi.model.EcoAction;
import com.learninspringboot.ecofootprintapi.service.EcoActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eco-action")
public class EcoActionController {

	@Autowired
	private EcoActionService service;
	
	@GetMapping("/list")
	public List<EcoAction> listEcoActions() {
		return service.listEcoActions();
	}
	
	@GetMapping(value = "/{id}")
	public Optional<EcoAction> getEcoActionById(@PathVariable("id") String id) {
		return service.getEcoActionById(id);
	}

}
