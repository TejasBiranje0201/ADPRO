package com.adpro.dto;

import java.sql.Date;

import lombok.Data;
@Data
public class InvoiceDto {
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
	private int agencyId;
	private int clientId;
}
