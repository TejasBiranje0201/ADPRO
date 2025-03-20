package com.adpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adpro.dto.HolidayDto;
import com.adpro.entity.Agency;
import com.adpro.entity.Holiday;
import com.adpro.service.AgencyService;
import com.adpro.service.HolidayService;

@RestController
@RequestMapping("/Holidays")
public class HolidayController {

	@Autowired
	private HolidayService holidayService;
	
	@Autowired
	private AgencyService agencyService;
	
	@PostMapping("/")
	public ResponseEntity<Holiday>save(@RequestBody HolidayDto holidayDto){
		
		Holiday holiday=new Holiday();
		
		Agency agency=agencyService.getById(holidayDto.getAgencyId());
		holiday.setAgency(agency);
	
		holiday.setHdate(holidayDto.getHdate());
		holiday.setReason(holidayDto.getReason());
		holiday.setEvery_year(holidayDto.isEvery_year());
		
		Holiday saveholiday=holidayService.save(holiday);
		
		return new ResponseEntity<>(saveholiday,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Holiday>>lists(){
		List<Holiday> holiday= holidayService.lists();
		if(holiday==null) {
			return new ResponseEntity<>(holiday,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(holiday,HttpStatus.FOUND);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Holiday>getById(@PathVariable("id") int id){
		
		Holiday holiday=holidayService.getById(id);
		
		if(holiday==null) {
			return new ResponseEntity<>(holiday,HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<>(holiday,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>deleteById(@PathVariable("id") int id){
		
		Holiday holiday =holidayService.getById(id);
		
		if(holiday==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Holiday>update(@PathVariable("id") int id,@RequestBody HolidayDto holidayDto){
		Holiday holiday= holidayService.getById(id);
		if(holiday==null) {
			return new ResponseEntity<>(holiday,HttpStatus.NOT_FOUND);
		}
		
		Agency agency=agencyService.getById(holidayDto.getAgencyId());
		holiday.setAgency(agency);
	
		holiday.setHdate(holidayDto.getHdate());
		holiday.setReason(holidayDto.getReason());
		holiday.setEvery_year(holidayDto.isEvery_year());
		
		Holiday saveholiday=holidayService.save(holiday);
		
		return new ResponseEntity<>(saveholiday,HttpStatus.OK);
	}
}
