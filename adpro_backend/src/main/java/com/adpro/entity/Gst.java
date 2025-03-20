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
@Table(name="gsts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Gst {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private float cgstpercent;
	private float sgstpercent;
	private float igstpercent;
	private String gstcode;
	
	@ManyToOne
	@JoinColumn(name="agencyId")
	@JsonIgnoreProperties(value={"agencyId"},allowSetters = true)
	private Agency agency;
	
}
