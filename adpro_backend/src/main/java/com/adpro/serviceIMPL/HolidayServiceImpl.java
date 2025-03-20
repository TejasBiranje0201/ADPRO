package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.Holiday;
import com.adpro.repository.HolidayRepository;
import com.adpro.service.HolidayService;
@Service
public class HolidayServiceImpl implements HolidayService {
	
	@Autowired
	private HolidayRepository holidayRepository;

	@Override
	public List<Holiday> lists() {
		
		return holidayRepository.findAll();
	}

	@Override
	public Holiday save(Holiday holiday) {
		
		return holidayRepository.save(holiday);
	}

	@Override
	public Holiday getById(int id) {
		
		return holidayRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(int id) {
	holidayRepository.deleteById(id);

	}

}
