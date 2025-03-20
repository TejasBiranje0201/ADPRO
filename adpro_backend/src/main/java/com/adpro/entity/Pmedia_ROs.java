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
public class Pmedia_ROs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int financialYear;
	private int rono;
	private Date roDate;
	private String centers;
	private String language;
	private String caption;
	private int noOfRecords;
	private int paidDays;
	private int freeDays;
	private double totalCharges;
	private double comissionPercent;
	private double comissionAmount;
	private int chequeNo;
	private Date chequaDate;
	private String bankName;
	private double roBillAmount;
	private String instructions;
	private double cgstPercent;
	private double cgstAmount;
	private double sgstPercent;
	private double sgstAmount;
	private double igstPercent;
	private double igstAmount;
	private double ccPercent;
	private double ccAmount;
	private String status;
	
	@ManyToOne
	@JoinColumn(name= "agencyId")
	@JsonIgnoreProperties(value = {"agencyId"}, allowSetters = true)
	private Agency agency;
	
	@ManyToOne
	@JoinColumn(name="clientId")
	@JsonIgnoreProperties(value = {"clientId"}, allowGetters = true)
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="pMediaId")
	@JsonIgnoreProperties(value = {"pMediaId"}, allowSetters = true)
	private P_medias p_medias;
	
	
//	gst pending
	
}
