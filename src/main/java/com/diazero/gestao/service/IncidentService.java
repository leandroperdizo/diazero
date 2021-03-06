package com.diazero.gestao.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.diazero.gestao.entity.Incident;

@Component
public interface IncidentService {

	public Page<Incident> findAll(Integer page, Integer size);
	
	public Page<Incident> findByIdIncident(Integer idIncident, Integer page, Integer size);

	public Incident save(Incident incident);

	public Optional<Incident> update(Incident incident);

	public void delete(Integer idIncident);

}
