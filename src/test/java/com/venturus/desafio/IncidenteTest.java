package com.venturus.desafio;

import com.diazero.gestao.config.VenturusConfig;
import com.diazero.gestao.entity.Incident;
import com.diazero.gestao.service.IncidentService;

import javax.annotation.Resource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = "com.venturus.*")
@EntityScan(basePackages = "com.venturus.desafio.entity")
@ContextConfiguration(classes = { VenturusConfig.class }, loader = AnnotationConfigContextLoader.class)
@Transactional
class IncidenteTest {

	@Resource
	IncidentService incidenteService;

	static Incident cliente = null;

	static Incident clienteAlt = null;

	static Incident clienteDelet = null;

	@BeforeAll
	static void setup() {

		cliente = new Incident();
		cliente.setName("clientenovo");
		cliente.setDescription("7687678670");

		clienteAlt = new Incident();
		clienteAlt.setName("clientenovoalt");
		clienteAlt.setDescription("7687678678");

		clienteDelet = new Incident();
		clienteDelet.setName("clientenovodelet");
		clienteDelet.setDescription("7687678677");
	}

	@AfterAll
	static void tearDown() {

		cliente = null;
		clienteAlt = null;
		clienteDelet = null;
	}

	@DisplayName("Salvar cliente com sucesso")
	@Test
	void testSalvarCliente() {

		assertNotNull(incidenteService.save(cliente));
		incidenteService.delete(cliente);
	}

	@DisplayName("Atualizar cliente com sucesso")
	@Test
	void testAtualizarCliente() {
		Incident cli = incidenteService.save(clienteAlt);
		cli.setName("clienteNome");
		assertNotNull(incidenteService.update(cli));
		incidenteService.delete(clienteAlt);
	}

	@DisplayName("Buscar clientes")
	@Test
	void testBuscarTodosOsClientes() {

		assertNotNull(incidenteService.findAll(clienteAlt.getName(), 0, 10));
	}

	@DisplayName("Deletar cliente")
	@Test
	void testDeletarCliente() {
		Incident cli = incidenteService.save(clienteDelet);
		incidenteService.delete(cli);
	}
}
