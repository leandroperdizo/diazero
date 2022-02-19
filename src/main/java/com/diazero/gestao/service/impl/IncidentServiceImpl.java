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
	private IncidentRepository incidentRepository;

	/**
	 * Find all incidents 
	 */
	@Override
	public Page<Incident> findAll(Integer page, Integer size) {

		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "name");
		return incidentRepository.findAll(pageRequest);
	}
	
	/**
	 * Find a incident by id  
	 */
	@Override
	public Page<Incident> findByIdIncident(Integer idIncident, Integer page, Integer size) {

		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "name");
		return incidentRepository.findByIdIncident(idIncident, pageRequest);
	}

	/**
	 * Save incident 
	 */
	@Override
	public Incident save(Incident incident) {

		return Optional.ofNullable(incident)
				.map(param -> incidentRepository.save(incident)).orElseGet(() -> new Incident());
	}

	/**
	 * Update incident 
	 */
	@Override
	public Optional<Incident> update(Incident incident) {

		return incidentRepository
				.findById(incident.getIdIncident())
				.map(param -> {			
					param.setName(incident.getName() == null ? param.getName() : incident.getName());
					param.setDescription(incident.getDescription() == null ? param.getDescription() : incident.getDescription());
			return incidentRepository.save(param);
		});
	}

	/**
	 * Delete incident 
	 */
	@Override
	public void delete(Integer idIncident) {

		incidentRepository.deleteById(idIncident);
	}
}
