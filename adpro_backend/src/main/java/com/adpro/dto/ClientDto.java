package com.adpro.dto;

import lombok.Data;

@Data
public class ClientDto {
	private String name;
	private long contact;
	private String address;
	private String gstno;
	private int agencyId;
	private int stateId;
}
