package com.adpro.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Pmedia_ROsDto {
	
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
	
	private int agencyId;
	private int clientId;
	private int pMediaId;
}
