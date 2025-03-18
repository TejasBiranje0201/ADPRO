package com.adpro.dto;

import lombok.Data;

@Data
public class MenuDto {
	
	private String title;
	private String link;
	private boolean isparent;
	private int parentId;
	private int srno;

}
