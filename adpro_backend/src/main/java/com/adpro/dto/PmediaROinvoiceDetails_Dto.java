package com.adpro.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class PmediaROinvoiceDetails_Dto {
	
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
	
	private int pmediaROdetailId;
}
