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

import com.adpro.dto.AgencyDto;
import com.adpro.entity.Agency;
import com.adpro.entity.State;
import com.adpro.service.AgencyService;
import com.adpro.service.StateService;

@RestController
@RequestMapping("/agency")
@CrossOrigin
public class AgencyController {
	@Autowired
	private AgencyService agencyService;

	private StateService stateService;

	@GetMapping("/")
	public ResponseEntity<List<Agency>> lists() {
		List<Agency> agencies = agencyService.lists();
		if (agencies == null) {
			return new ResponseEntity<>(agencies, HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<>(agencies, HttpStatus.FOUND);
		
	} 
	
	@GetMapping("/{id}")
	public ResponseEntity<Agency> getById(@PathVariable("id")int id){
		Agency agency = agencyService.getById(id);
		if (agency == null) {
			return new ResponseEntity<>(agency, HttpStatus.NOT_FOUND);
			

		}
		return new ResponseEntity<>(agency, HttpStatus.FOUND);
		

		
	}
 
	@PostMapping("/")
	public ResponseEntity<Agency> save(@RequestBody AgencyDto agencyDto) {

		Agency agency = new Agency();
		agency.setName(agencyDto.getName());
		agency.setAddress(agencyDto.getAddress());
		agency.setCity(agencyDto.getCity());
		agency.setGstno(agencyDto.getGstno());
		agency.setOwner(agencyDto.getOwner());
		agency.setContact(agencyDto.getContact());
		agency.setEmail(agencyDto.getEmail());
		agency.setLogopath(agencyDto.getLogopath());
		agency.setSignpath(agencyDto.getSignpath());
		agency.setStamppath(agencyDto.getStamppath());
		agency.setPanno(agencyDto.getPanno());
		agency.setBankname(agencyDto.getBankname());
		agency.setIfsccode(agencyDto.getIfsccode());
		agency.setAccountno(agencyDto.getAccountno());
		agency.setWebsite(agencyDto.getWebsite());
		agency.setInstructions(agencyDto.getInstructions());

		State state = stateService.getByid(agencyDto.getStateid());
		agency.setStateid(state);

		Agency savedAgency = agencyService.save(agency);

		return new ResponseEntity<>(savedAgency, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Agency> update (@PathVariable("id")int id,@RequestBody AgencyDto agencyDto){
		Agency agency = agencyService.getById(id);
		if (agency == null) {
			return new ResponseEntity<>(agency, HttpStatus.NOT_FOUND);
			

		}
		agency.setName(agencyDto.getName());
		agency.setAddress(agencyDto.getAddress());
		agency.setCity(agencyDto.getCity());
		agency.setGstno(agencyDto.getGstno());
		agency.setOwner(agencyDto.getOwner());
		agency.setContact(agencyDto.getContact());
		agency.setEmail(agencyDto.getEmail());
		agency.setLogopath(agencyDto.getLogopath());
		agency.setSignpath(agencyDto.getSignpath());
		agency.setStamppath(agencyDto.getStamppath());
		agency.setPanno(agencyDto.getPanno());
		agency.setBankname(agencyDto.getBankname());
		agency.setIfsccode(agencyDto.getIfsccode());
		agency.setAccountno(agencyDto.getAccountno());
		agency.setWebsite(agencyDto.getWebsite());
		agency.setInstructions(agencyDto.getInstructions());

		State state = stateService.getByid(agencyDto.getStateid());
		agency.setStateid(state);

		Agency savedAgency = agencyService.save(agency);

		return new ResponseEntity<>(savedAgency, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>  deleteById(@PathVariable("id")int id ){
		Agency agency = agencyService.getById(id);
		if (agency == null) {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);

		}
		
		agencyService.deleteById(id);
		return new ResponseEntity<>( HttpStatus.MOVED_PERMANENTLY);
	}

}
