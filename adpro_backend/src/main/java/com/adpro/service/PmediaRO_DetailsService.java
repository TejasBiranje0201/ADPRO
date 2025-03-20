package com.adpro.service;

import java.util.List;

import com.adpro.entity.PmediaRO_Details;

public interface PmediaRO_DetailsService {
	
	public List<PmediaRO_Details> getAll();
	
	public PmediaRO_Details getById(int id);
	
	public PmediaRO_Details save(PmediaRO_Details pmediaRO_Details);
	
	public void delete(int id);
}
