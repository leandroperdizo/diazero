package com.diazero.gestao.service.impl;

import com.diazero.gestao.entity.Incident;
import com.diazero.gestao.repository.IncidentRepository;
import com.diazero.gestao.service.IncidentService;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class IncidentServiceImpl implements IncidentService {

	@Autowired
	private IncidentRepository clienteRepository;

	/**
	 * Find all incidents 
	 */
	@Override
	public Page<Incident> findAll(Integer page, Integer size) {

		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");
		return clienteRepository.findAll(pageRequest);
	}
	
	/**
	 * Find a incident by id  
	 */
	@Override
	public Page<Incident> findByIdIncident(Integer idIncident, Integer page, Integer size) {

		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");
		return clienteRepository.findByIdIncident(idIncident, pageRequest);
	}

	/**
	 * Salvar cliente 
	 */
	@Override
	public Incident save(Incident cliente) {

		return Optional.ofNullable(cliente)
				.map(param -> clienteRepository.save(cliente)).orElseGet(() -> new Incident());
	}

	/**
	 * Atualizar cliente 
	 */
	@Override
	public Optional<Incident> update(Incident cliente) {

		return clienteRepository
				.findById(cliente.getIdIncident())
				.map(param -> {			
					param.setName(cliente.getName() == null ? param.getName() : cliente.getName());
			return clienteRepository.save(param);
		});
	}

	/**
	 * Deletar cliente 
	 */
	@Override
	public void delete(Incident cliente) {

		clienteRepository.delete(cliente);
	}
}
