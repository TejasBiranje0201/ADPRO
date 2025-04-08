package com.adpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adpro.dto.WorkScheduleDto;
import com.adpro.entity.Agency;
import com.adpro.entity.User;
import com.adpro.entity.WorkSchedule;
import com.adpro.service.AgencyService;
import com.adpro.service.UserService;
import com.adpro.service.WorkScheduleService;

@RestController
@RequestMapping("/worschedule")
@CrossOrigin
public class WorkScheduleController {

	@Autowired
	private WorkScheduleService workScheduleService;
	@Autowired
	private AgencyService agencyService;
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public ResponseEntity<List<WorkSchedule>> list(){
			List<WorkSchedule> workSchedules = workScheduleService.list();
			if (workSchedules==null) {
				return new ResponseEntity<>(workSchedules,HttpStatus.NOT_FOUND);
				
			}
			return new ResponseEntity<>(workSchedules,HttpStatus.FOUND);
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<WorkSchedule> getById(@PathVariable("id") int id) {
		WorkSchedule workSchedule = workScheduleService.geyById(id);
		if (workSchedule == null) {
			return new ResponseEntity<>(workSchedule, HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<>(workSchedule, HttpStatus.FOUND);
	}
	
	@PostMapping("/")
	public ResponseEntity<WorkSchedule> save(@RequestBody WorkScheduleDto workScheduleDto){
		WorkSchedule workSchedule = new WorkSchedule();
		workSchedule.setTitle(workScheduleDto.getTitle());
		workSchedule.setStatus(workScheduleDto.getStatus());
		workSchedule.setWdate(workScheduleDto.getWdate());
		workSchedule.setDescription(workScheduleDto.getDescription());
		
		
		Agency agency = agencyService.getById(workScheduleDto.getAgencyId());
		workSchedule.setAgency(agency);
		
		User user = userService.getById(workScheduleDto.getUserId());
		workSchedule.setUser(user);
		
		WorkSchedule saveWorkSchedule = workScheduleService.save(workSchedule);
		return new ResponseEntity<>(saveWorkSchedule, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<WorkSchedule> update(@PathVariable("id") int id,@RequestBody WorkScheduleDto workScheduleDto){
		WorkSchedule workSchedule = workScheduleService.geyById(id);
		if (workSchedule == null) {
			return new ResponseEntity<>(workSchedule, HttpStatus.NOT_FOUND);
		}
			workSchedule.setTitle(workScheduleDto.getTitle());
			workSchedule.setStatus(workScheduleDto.getStatus());
			workSchedule.setWdate(workScheduleDto.getWdate());
			workSchedule.setDescription(workScheduleDto.getDescription());
			
			
			Agency agency = agencyService.getById(workScheduleDto.getAgencyId());
			workSchedule.setAgency(agency);
			
			User user = userService.getById(workScheduleDto.getUserId());
			workSchedule.setUser(user);
			
			WorkSchedule saveWorkSchedule = workScheduleService.save(workSchedule);
			return new ResponseEntity<>(saveWorkSchedule, HttpStatus.CREATED);
		

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id")int id){
		WorkSchedule workSchedule = workScheduleService.geyById(id);
		if (workSchedule == null) {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
		workScheduleService.deleteById(id);
		return new ResponseEntity<>( HttpStatus.MOVED_PERMANENTLY);
	}

}
