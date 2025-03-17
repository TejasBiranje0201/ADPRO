package com.adpro.dto;

import lombok.Data;

@Data
public class InvoicedetailDto {

	private int invoiceid;
	private int srno;
	private String name;
	private String description;
	private int quantity;
	private int rate;
	private double amount;
}
