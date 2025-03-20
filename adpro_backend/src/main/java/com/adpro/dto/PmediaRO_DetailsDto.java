package com.adpro.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class PmediaRO_DetailsDto {
	
	
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
	
	private int pmediaroId;
}
