package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.Gst;
import com.adpro.repository.GstRepository;
import com.adpro.service.GstService;
@Service
public class GstServiceImpl implements GstService {

	@Autowired
	private GstRepository gstRepository;
	@Override
	public List<Gst> lists() {
		
		return gstRepository.findAll();
	}

	@Override
	public Gst getById(int id) {
		
		return gstRepository.findById(id).orElse(null);
	}

	@Override
	public Gst save(Gst gst) {
	
		return gstRepository.save(gst);
	}

	@Override
	public void deleteById(int id) {
		gstRepository.deleteById(id);

	}

}
