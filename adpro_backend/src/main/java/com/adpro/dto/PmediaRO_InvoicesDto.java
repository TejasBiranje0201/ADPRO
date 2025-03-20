package com.adpro.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class PmediaRO_InvoicesDto {
	
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
	
	private int agencyId;
	private int pmediaRO_Id;
}
