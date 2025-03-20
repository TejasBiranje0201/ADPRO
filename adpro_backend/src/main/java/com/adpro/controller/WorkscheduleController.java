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

import com.adpro.dto.WorkscheduleDto;
import com.adpro.entity.Agency;
import com.adpro.entity.User;
import com.adpro.entity.Workschedule;
import com.adpro.service.AgencyService;
import com.adpro.service.UserService;
import com.adpro.service.WorkscheduleService;

@RestController
@RequestMapping("/Workschedules")
public class WorkscheduleController {
	@Autowired
	private WorkscheduleService workscheduleService;
	
	@Autowired
	private AgencyService agencyService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<Workschedule>save(@RequestBody WorkscheduleDto workscheduleDto){
		
		Workschedule workschedule= new Workschedule();
		workschedule.setTitle(workscheduleDto.getTitle());
		workschedule.setDescription(workscheduleDto.getDescription());
		workschedule.setWdate(workscheduleDto.getWdate());
		workschedule.setStatus(workscheduleDto.getStatus());
		Agency agency=agencyService.getById(workscheduleDto.getAgencyId());
		workschedule.setAgency(agency);
		
		User user=userService.getById(workscheduleDto.getUserId());
		workschedule.setUser(user);
		
		Workschedule saveworkschedule=workscheduleService.save(workschedule);
		return new ResponseEntity<>(saveworkschedule,HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<List<Workschedule>>lists(){
		List<Workschedule> workschedule=workscheduleService.lists();
		
		if(workschedule==null) {
			return new ResponseEntity<>(workschedule,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(workschedule,HttpStatus.FOUND);
		
	}
	
	@GetMapping("/{ID}")
	public ResponseEntity<Workschedule>getById(@PathVariable("id") int id){
		Workschedule workschedule=workscheduleService.getById(id);
		
		if(workschedule==null) {
			return new ResponseEntity<>(workschedule,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(workschedule,HttpStatus.FOUND);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>deleteById(@PathVariable("id") int id){
		Workschedule workschedule=workscheduleService.getById(id);
		
		if(workschedule==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
		
	}
	
	@PutMapping("/{id}")
		public ResponseEntity<Workschedule>update(@PathVariable("id")int id,@RequestBody WorkscheduleDto workscheduleDto){
		Workschedule workschedule=workscheduleService.getById(id);
		
		if(workschedule==null) {
			return new ResponseEntity<>(workschedule,HttpStatus.NOT_FOUND);
		}
		
		workschedule.setTitle(workscheduleDto.getTitle());
		workschedule.setDescription(workscheduleDto.getDescription());
		workschedule.setWdate(workscheduleDto.getWdate());
		workschedule.setStatus(workscheduleDto.getStatus());
		Agency agency=agencyService.getById(workscheduleDto.getAgencyId());
		workschedule.setAgency(agency);
		
		User user=userService.getById(workscheduleDto.getUserId());
		workschedule.setUser(user);
		
		Workschedule updateworkschedule=workscheduleService.save(workschedule);
		return  new ResponseEntity<>(updateworkschedule,HttpStatus.OK);
	}
}
