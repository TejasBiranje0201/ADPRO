package com.adpro.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdSchedules {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date adDate;
	private String description;
	private String beforeClientMessage;
	private String beforeAgencyMessage;
	private String onDateClientMessage;
	private String onDateAgencyMessage;
	
	@ManyToOne
	@JoinColumn(name="agencyId")
	@JsonIgnoreProperties(value = {"agencyId"},allowSetters = true)
	private Agency agency;
	
	@ManyToOne
	@JoinColumn(name = "clientId")
	@JsonIgnoreProperties(value = {"clientId"},allowSetters = true)
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "pmediaId")
	@JsonIgnoreProperties(value = {"pmediaId"},allowSetters = true)
	private P_medias p_medias;
	
	@ManyToOne
	@JoinColumn(name = "pmediaRoId")
	@JsonIgnoreProperties(value = {"pmediaRoId"},allowSetters = true)
	private Pmedia_ROs pmedia_ROs;
	
}
