package com.adpro.entity;

import java.sql.Date;

import java.sql.Time;

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
@Table(name="Emediarodetails")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Emediarodetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private int emediarodetailid;
	private int srno;
	private Date fromtodate;
	private int noofdays;
	private Time fromtime;
	private Time totime;
	private int dailyspots;
	private int totalspots;
	private double bonuspaid;
	private double charges;
	private int duration;
	private double totalcharges;
	private String caption;
	
	
	
}
