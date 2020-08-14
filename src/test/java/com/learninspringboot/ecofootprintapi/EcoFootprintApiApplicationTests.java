package com.learninspringboot.ecofootprintapi;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.learninspringboot.ecofootprintapi.model.EcoAction;
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
						new EcoFootprint(
								"User Test",
								"1",
								"as123sd123s",
								"ecoFootPrint1",
								UUID.randomUUID().toString(),
								new ArrayList<>(Arrays.asList(new EcoAction("Transporte publico", null, 1.23, 2), new EcoAction("Coche Eléctrico", "Ciudad", 1.23, 2)))),
						new EcoFootprint(
								"User Test",
								"2",
								"as123sd123s",
								"ecoFootPrint2",
								UUID.randomUUID().toString(),
								new ArrayList<>(Arrays.asList(new EcoAction("Transporte publico", null, 1.23, 2), new EcoAction("Coche Eléctrico", "Ciudad", 1.23, 2))))
				).collect(Collectors.toList())
		);
		
		assertEquals(2, service.listFootprints().size());
	}

	@Test
	public void getEcoFootprintByIdTest() {
		String id = "1";
		EcoFootprint ecoFootprint = new EcoFootprint(
				"User Test",
				"1",
				"as123sd123s",
				"ecoFootPrint1",
				UUID.randomUUID().toString(),
				new ArrayList<>(Arrays.asList(new EcoAction("Transporte publico", null, 1.23, 2), new EcoAction("Coche Eléctrico", "Ciudad", 1.23, 2))));
		when(repo.findById(id)).thenReturn(Optional.of(ecoFootprint));

		Optional<EcoFootprint> serviceEcoFootprint = service.getFootprintById(id);
		assertEquals(Optional.of(ecoFootprint), serviceEcoFootprint);
	}

	@Test
	public void createFootprintTest() {
		EcoFootprint ecoFootprint = new EcoFootprint(
				"User Test",
				"1",
				"as123sd123s",
				"ecoFootPrint1",
				UUID.randomUUID().toString(),
				new ArrayList<>(Arrays.asList(new EcoAction("Transporte publico", null, 1.23, 2), new EcoAction("Coche Eléctrico", "Ciudad", 1.23, 2))));
		when(repo.save(ecoFootprint)).thenReturn(ecoFootprint);

		assertEquals(ecoFootprint, service.createFootprint(ecoFootprint));
	}

	@Test
	public void updateFootprintTest() {
		EcoFootprint ecoFootprint = new EcoFootprint(
				"User Test",
				"1",
				"as123sd123s",
				"ecoFootPrint1",
				UUID.randomUUID().toString(),
				new ArrayList<>(Arrays.asList(new EcoAction("Transporte publico", null, 1.23, 2), new EcoAction("Coche Eléctrico", "Ciudad", 1.23, 2))));
		when(repo.save(ecoFootprint)).thenReturn(ecoFootprint);

		assertEquals(ecoFootprint, service.updateFootprint(ecoFootprint));
	}

	@Test
	public void deleteFootprintTest() {
		String id = "1";
		EcoFootprint ecoFootprint = new EcoFootprint(
				"User Test",
				"1",
				"as123sd123s",
				"ecoFootPrint1",
				UUID.randomUUID().toString(),
				new ArrayList<>(Arrays.asList(new EcoAction("Transporte publico", null, 1.23, 2), new EcoAction("Coche Eléctrico", "Ciudad", 1.23, 2))));
		service.deleteFootprint("1");

		verify(repo, times(1)).deleteById("1");
	}

}
