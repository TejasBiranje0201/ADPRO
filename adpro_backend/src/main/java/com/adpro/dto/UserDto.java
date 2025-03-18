package com.adpro.dto;

import java.sql.Date;


import lombok.Data;
@Data
public class UserDto {
	
	private String email;
	private String password;
	private String name;
	private Date createdon;
	private int agencyId;
	private int uroleid;

}
