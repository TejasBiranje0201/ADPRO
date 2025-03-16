package com.adpro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="Invoicedetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Invoicedetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int invoiceid;
	private int srno;
	private String name;
	private String description;
	private int quantity;
	private int rate;
	private double amount;
	

}
