package com.learninspringboot.ecofootprintapi;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.learninspringboot.ecofootprintapi.model.EcoFootprint;
import com.learninspringboot.ecofootprintapi.repo.EcoFootprintRepo;
import com.learninspringboot.ecofootprintapi.service.EcoFootprintService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EcoFootprintApiApplicationTests {

	@Autowired
	private EcoFootprintService service;
	
	@MockBean
	private EcoFootprintRepo repo;
	
	@Test
	public void getEcoFootprintsTest() {
		when(repo.findAll()).thenReturn(
				Stream.of(
						new EcoFootprint("User Test", "1", UUID.randomUUID().toString()),
						new EcoFootprint("User Test", "2", UUID.randomUUID().toString())
				).collect(Collectors.toList())
		);
		
		assertEquals(2, service.listFootprints().size());
	}
	
}
