package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.Workschedule;
import com.adpro.repository.WorkscheduleRepository;
import com.adpro.service.WorkscheduleService;

@Service
public class WorkscheduleServiceImpl implements WorkscheduleService {
	@Autowired
	private WorkscheduleRepository workscheduleRepository;
	@Override
	public List<Workschedule> lists() {
		
		return workscheduleRepository.findAll();
	}

	@Override
	public Workschedule getById(int id) {
		// TODO Auto-generated method stub
		return workscheduleRepository.findById(id).orElse(null);
	}

	@Override
	public Workschedule save(Workschedule workschedule) {
		// TODO Auto-generated method stub
		return workscheduleRepository.save(workschedule);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		workscheduleRepository.deleteById(id);
	}

}
