package com.adpro.service;

import java.util.List;

import com.adpro.entity.P_medias;

public interface P_mediasService {

	
	public List<P_medias> getAll();
	
	public P_medias getById(int id);
	
	public P_medias save(P_medias p_medias);
	
	public void delete(int id);
}
