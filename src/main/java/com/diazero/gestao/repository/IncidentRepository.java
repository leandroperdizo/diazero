package com.diazero.gestao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.diazero.gestao.entity.Incident;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Integer> {

	Page<Incident> findAll(Pageable Pageable);
	
	Page<Incident> findByIdIncident(@Param("idIncident") Integer idIncident, Pageable Pageable);

}
