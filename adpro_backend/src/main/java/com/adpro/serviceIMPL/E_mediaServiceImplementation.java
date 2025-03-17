package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.E_media;
import com.adpro.repository.E_mediaRepository;
import com.adpro.service.E_mediaService;

@Service
public class E_mediaServiceImplementation implements E_mediaService {
	
	@Autowired
	private E_mediaRepository e_mediaRepository;

	@Override
	public List<E_media> getAll() {
		
		return e_mediaRepository.findAll();
	}

	@Override
	public E_media getbyId(int id) {
		
		return e_mediaRepository.findById(id).orElse(null);
	}

	@Override
	public E_media save(E_media e_media) {
		
		return e_mediaRepository.save(e_media);
	}

	@Override
	public void delete(int id) {
		e_mediaRepository.deleteById(id);
		
	}

}
