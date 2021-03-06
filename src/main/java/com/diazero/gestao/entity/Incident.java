package com.diazero.gestao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "incident")
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Incident implements Serializable {

	/**
	 * Serial Version ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * IdIncident
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idIncident;

	/**
	 * Name
	 */
	private String name;

	/**
	 * Description
	 */
	private String description;
	
	/**
	 * CreatedAt
	 */
	@CreationTimestamp
	private Date createdAt;
	
	/**
	 * UpdatedAt
	 */
	@UpdateTimestamp
	private Date updatedAt;
	
	/**
	 * ClosedAt
	 */
	@UpdateTimestamp
	private Date closedAt;

	

}
