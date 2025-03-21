package com.adpro.dto;

import lombok.Data;

@Data
public class GstDto {
	private String title;
	private float cgstpercent;
	private float sgstpercent;
	private float igstpercent;
	private String gstcode;
	private int agencyid;

}
