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
public class PmediaROinvoiceDetails {
	
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
	private double charges;
	private float comissionPercent;
	private double comissionAmount;
	private String position;
	private int chequeNo;
	private Date chequeDate;
	private double totalCharges;
	private float ccPercent;
	private double ccAmount;
	private double finalCharges;
	private long invoiceNo;
	private double gstAmount;
	private double cgstAmount;
	private double sgstAmount;
	private double igstAmount;
	
	@ManyToOne
	@JoinColumn(name = "pmediaROdetailId")
	@JsonIgnoreProperties(value = {"pmediaROdetailId"},allowSetters = true)
	private PmediaRO_Details pmediaRO_Details;
	
//	hue is Pending;
 	

}
