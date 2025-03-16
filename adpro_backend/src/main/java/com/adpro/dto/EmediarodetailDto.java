package com.adpro.dto;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;
@Data
public class EmediarodetailDto {
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
