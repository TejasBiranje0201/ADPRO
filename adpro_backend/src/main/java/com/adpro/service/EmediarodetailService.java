package com.adpro.service;

import java.util.List;

import com.adpro.entity.Emediarodetail;

public interface EmediarodetailService {
	
	List<Emediarodetail>lists();
	
	Emediarodetail getById(int id);
	
	Emediarodetail save(Emediarodetail emediarodetail);
	
	void deleteById(int id);

}
