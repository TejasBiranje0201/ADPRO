package com.adpro.service;

import java.util.List;

import com.adpro.entity.Gst;

public interface GstService {

	List<Gst>lists();
	
	Gst getById(int id);
	
	Gst save(Gst gst);
	
	void deleteById(int id);
}
