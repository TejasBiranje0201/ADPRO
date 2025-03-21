package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.WorkSchedule;
import com.adpro.repository.workScheduleRepository;
import com.adpro.service.WorkScheduleService;
@Service
public class WorkScheduleServiceIMPL implements WorkScheduleService {

	@Autowired
	private workScheduleRepository workScheduleRepository;
	
	@Override
	public List<WorkSchedule> list() {
		// TODO Auto-generated method stub
		return workScheduleRepository.findAll();
	}

	@Override
	public WorkSchedule geyById(int id) {
		// TODO Auto-generated method stub
		return workScheduleRepository.findById(id).orElse(null);
	}

	@Override
	public WorkSchedule save(WorkSchedule workSchedule) {
		// TODO Auto-generated method stub
		return workScheduleRepository.save(workSchedule);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		workScheduleRepository.deleteById(id);
	}

}
