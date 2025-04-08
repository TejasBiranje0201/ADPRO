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
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PmediaRO_Invoices {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int financialYear;
	private int invoiceNo;
	private Date invoiceDate;
	private double totalCharges;
	private float comissionAmount;
	private float roBillAmount;
	private float discountPercent;
	private float dicountAmount;
	private float cgstPercent;
	private float cgstAmount;
	private float sgstPercent;
	private float sgstAmount;
	private float igstPercent;
	private float igstAmount;
	private double billAmount;
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "agencyId")
	@JsonIgnoreProperties(value = {"agencyId"},allowSetters = true)
	private Agency agency;
	
	@ManyToOne
	@JoinColumn(name = "pmediaRO_Id")
	@JsonIgnoreProperties(value = {"pmediaRO_Id"},allowSetters = true)
	private Pmedia_ROs pmedia_ROs;
	
//	gst pending
	
	@ManyToOne
	@JoinColumn(name = "gstId")
	@JsonIgnoreProperties(value = {"gstId"},allowSetters = true)
	private Gst gst;
}
