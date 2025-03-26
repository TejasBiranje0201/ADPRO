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
@Table(name="Invoices")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int financialyear;
	private int invoiceno;
	private Date invoicedate;
	private int itemcount;
	private double amount;
	private float discount;
	private double taxableamount;
	private float cgstpercent;
	private double cgstamount;
	private float sgetpercent;
	private double igstamount;
	private float igstpercent;
	private double billamount;
	
	@ManyToOne
	@JoinColumn(name="agencyId")
	@JsonIgnoreProperties(value= {"agencyId"},allowSetters = true)
	private Agency agency;
	
	@ManyToOne
	@JoinColumn(name="clientId")
	@JsonIgnoreProperties(value= {"clientId"},allowSetters = true)
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="gstId")
	@JsonIgnoreProperties(value= {"gstId"},allowSetters = true)
	private Gst gst;
	
	
	
}
