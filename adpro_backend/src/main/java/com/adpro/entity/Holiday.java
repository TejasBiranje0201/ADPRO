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

@Entity
@Table(name="Holidays")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Holiday {

	private int id;
	private Date hdate;
	private String reason;
	private boolean every_year;
	
	@ManyToOne
	@JoinColumn(name="agencyId")
	@JsonIgnoreProperties(value = {"agencyId"},allowSetters = true)
	private Agency agency;
	
}
