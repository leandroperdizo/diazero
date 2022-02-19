package com.diazero.gestao.desafio;

import static org.junit.Assert.assertNotNull;
import javax.annotation.Resource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.diazero.gestao.entity.Incident;
import com.diazero.gestao.service.IncidentService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = "com.diazero.*")
@EntityScan(basePackages = "com.diazero.gestao.entity")
@Transactional
class IncidentTest {

	@Resource
	IncidentService incidenteService;

	static Incident incident = null;

	static Incident incidentAlt = null;

	static Incident incidentDelet = null;

	@BeforeAll
	static void setup() {

		incident = new Incident();
		incident.setName("incidentnovo");
		incident.setDescription("7687678670");

		incidentAlt = new Incident();
		incidentAlt.setName("incidentnovoalt");
		incidentAlt.setDescription("7687678678");

		incidentDelet = new Incident();
		incidentDelet.setName("incidentnovodelet");
		incidentDelet.setDescription("7687678677");
	}

	@AfterAll
	static void tearDown() {

		incident = null;
		incidentAlt = null;
		incidentDelet = null;
	}

	@DisplayName("Save incident successfully")
	@Test
	void testSaveIncident() {

		assertNotNull(incidenteService.save(incident));
		incidenteService.delete(incident.getIdIncident());
	}

	@DisplayName("Update incident successfully")
	@Test
	void testUpdateIncident() {
		Incident cli = incidenteService.save(incidentAlt);
		cli.setName("incidentName");
		assertNotNull(incidenteService.update(cli));
		incidenteService.delete(incidentAlt.getIdIncident());
	}

	@DisplayName("Find all incidents")
	@Test
	void testFindAllincidents() {

		assertNotNull(incidenteService.findAll(0, 10));
	}

	@DisplayName("Delete incident")
	@Test
	void testDeleteIncident() {
		Incident cli = incidenteService.save(incidentDelet);
		incidenteService.delete(cli.getIdIncident());
	}
}
