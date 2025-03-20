package com.adpro.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="WorkSchedules")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class WorkSchedule {
	
	
	private int id;
	private String title;
	private String  description;
	private Date wdate;
	private String status;
	@ManyToOne
	@JoinColumn(name="agencyId")
	@JsonIgnoreProperties(value = {"agencyId"},allowSetters = true)
	private Agency agency;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	@JsonIgnoreProperties(value = {"userId"},allowSetters = true)
	private User user;

}
