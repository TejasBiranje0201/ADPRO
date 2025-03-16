package com.adpro.dto;

import java.sql.Date;

import lombok.Data;
@Data
public class FinancialyearDto {
	private String name;
	private Date startdate;
	private Date enddate;

}
