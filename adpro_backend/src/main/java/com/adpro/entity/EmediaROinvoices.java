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
public class EmediaROinvoices {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int financialYear;
	private int roNo;
	private Date roDate;
	private String centers;
	private String language;
	private String caption;
	private int noOfRecords;
	private int totalSpots;
	private float totalCharges;
	private float comissionPercent;
	private double comissionAmount;
	private int chequeNo;
	private Date chequeDate;
	private String bankName;
	private double roBillAmount;
	private String instructions;
	private float cgstPercent;
	private double cgstAmount;
	private float sgstPercent;
	private double sgstAmount;
	private float igstPercent;
	private double igstAmount;
	private float ccPercent;
	private double ccAmount;
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "agencyId")
	@JsonIgnoreProperties(value = {"agencyId"},allowSetters = true)
	private Agency agency;
	
	@ManyToOne
	@JoinColumn(name="emediaroId")
	@JsonIgnoreProperties(value = {"emediaroId"},allowSetters = true)
	private EmediaROs emediaROs;
	
	@ManyToOne
	@JoinColumn(name="clientId")
	@JsonIgnoreProperties(value = {"clientId"},allowSetters = true)
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="emediaId")
	@JsonIgnoreProperties(value = {"emediaId"},allowSetters = true)
	private E_media e_media;
	
//	gst Pending
	
	@ManyToOne
	@JoinColumn(name = "gstId")
	@JsonIgnoreProperties(value = {"gstId"},allowSetters = true)
	private Gst gst;
}
