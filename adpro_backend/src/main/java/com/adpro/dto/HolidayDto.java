package com.adpro.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class HolidayDto {
	
	private Date hdate;
	private String reason;
	private boolean every_year;
	private int agencyId;
}
