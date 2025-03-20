package com.adpro.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class WorkScheduleDto {

	
	private int id;
	private String title;
	private String  description;
	private Date wdate;
	private String status;
	private int agencyId;
	private int userId;
}
