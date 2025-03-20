package com.adpro.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class EmediaROs_Dto {
	
	private Date financialYear;
	private int roNo;
	private Date roDate;
	private String centers;
	private String language;
	private String caption;
	private int noOfRecords;
	private int totalSpots;
	private double totalCharges;
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
	
	private int agencyId;
	private int clientId;
	private int emediaId;
	
}
