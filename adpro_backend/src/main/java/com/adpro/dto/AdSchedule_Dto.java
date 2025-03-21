package com.adpro.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class AdSchedule_Dto {

	
	private Date adDate;
	private String description;
	private String beforeClientMessage;
	private String beforeAgencyMessage;
	private String onDateClientMessage;
	private String onDateAgencyMessage;
	
	private int agencyId;
	private int clientId;
	private int pmediaId;
	private int pmediaRoId;
}
