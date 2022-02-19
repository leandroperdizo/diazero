package com.diazero.gestao.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.diazero.gestao.entity.Incident;
import com.diazero.gestao.service.IncidentService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/incident")
public class IncidentController {

	@Autowired
	IncidentService incidentService;

	/**
	 * Find all incidents  
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	@ApiOperation("Find all incidents")
	@GetMapping
	public ResponseEntity<?> findAll(@RequestParam(value = "page", required = true) Integer page,
			@RequestParam(value = "size", required = true) Integer size) {

		return new ResponseEntity<Page<Incident>>(incidentService.findAll(page, size), HttpStatus.OK);
	}
	
	/**
	 * Find incident by id  
	 * 
	 * @param id
	 * @param page
	 * @param size
	 * @return
	 */
	@ApiOperation("Find incident by id")
	@GetMapping("/findByIdIncident")
	public ResponseEntity<?> findByIdIncident(@RequestParam(value = "idIncident", required = true) Integer idIncident,
			@RequestParam(value = "page", required = true) Integer page,
			@RequestParam(value = "size", required = true) Integer size) {

		return new ResponseEntity<Page<Incident>>(incidentService.findByIdIncident(idIncident, page, size), HttpStatus.OK);
	}

	/**
	 * Save incident 
	 * 
	 * @param incident
	 * @return
	 */
	@ApiOperation("Save incident")
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Incident incident) {

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(Optional.of(incident).map(incidentService::save).orElseThrow());
	}

	/**
	 * Update incident 
	 * 
	 * @param incident
	 * @return
	 */
	@ApiOperation("Update incident")
	@PutMapping
	public ResponseEntity<Optional<Incident>> update(@RequestBody Incident incident) {

		return new ResponseEntity<Optional<Incident>>(Optional.of(incident).map(incidentService::update).orElseThrow(),
				HttpStatus.OK);
	}

	/**
	 * Delete incident 
	 * 
	 @param incident
	 */
	@ApiOperation("Delete incident")
	@DeleteMapping("/{idIncident}")
	public void delete(@PathVariable Integer idIncident) {

		incidentService.delete(idIncident);
	}

}
