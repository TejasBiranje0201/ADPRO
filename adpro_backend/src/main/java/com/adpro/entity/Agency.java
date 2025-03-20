package com.adpro.entity;

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
@Table(name="Agencies")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Agency {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private String city;
	private long gstno;
	private String owner;
	private long contact;
	private String email;
	private String logopath;
	private String signpath;
	private String stamppath;
	private String panno;
	private String bankname;
	private String ifsccode;
	private long accountno;
	private String website;
	private String instructions;
	private String status;
	
	
	@ManyToOne
	@JoinColumn(name="stateId")
	@JsonIgnoreProperties(value= {"stateid"}, allowSetters =true)
	private State stateid;

}
