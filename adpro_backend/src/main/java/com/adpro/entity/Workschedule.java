package com.adpro.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="Workschedules")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Workschedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	private Date wdate;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="agencyId")
	@JsonIgnoreProperties(value= {"agencyId"},allowSetters = true)
	private Agency agency;
	
	@ManyToOne
	@JoinColumn(name="userId")
	@JsonIgnoreProperties(value= {"userId"},allowSetters =true)
	private User user;
	
	
}
