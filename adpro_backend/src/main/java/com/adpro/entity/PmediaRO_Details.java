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
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PmediaRO_Details {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int srNo;
	private Date pDate;
	private String caption;
	private float width;
	private float height;
	private float area;
	private float rate;
	private float charges;
	private float comissionPercent;
	private float comissionAmount;
	private String positon;
	private int chequeNo;
	private Date chequeDate;
	private double totalCharges;
	private float ccPercent;
	private double ccAmount;
	private double finalCharges;
	private int invoiceNo;
	private float gstAmount;
	private float cgstAmount;
	private float sgstAmount;
	private float igstAmount;
	
//	hue is pending
	
	@ManyToOne
	@JoinColumn(name = "pmediaroId")
	@JsonIgnoreProperties(value = {"pmediaroId"},allowSetters = true)
	private Pmedia_ROs pmedia_ROs;
	
}
