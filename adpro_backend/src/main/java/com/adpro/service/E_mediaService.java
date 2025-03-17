package com.adpro.service;

import java.util.List;

import com.adpro.entity.E_media;

public interface E_mediaService {
	
	public List<E_media> getAll();
	
	public E_media getbyId(int id);
	
	public E_media save(E_media e_media);
	
	public void delete(int id);
}
