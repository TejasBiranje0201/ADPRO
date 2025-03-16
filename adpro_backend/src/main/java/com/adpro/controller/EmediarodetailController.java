package com.adpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adpro.dto.EmediarodetailDto;
import com.adpro.entity.Emediarodetail;
import com.adpro.service.EmediarodetailService;

@RestController
@RequestMapping("/Emediarodetails")
public class EmediarodetailController {
	
	@Autowired
	private EmediarodetailService emediarodetailService;
	
	@PostMapping("/")
	public ResponseEntity<Emediarodetail>save(@RequestBody EmediarodetailDto emediarodetailDto){
		
		Emediarodetail emediarodetail =new Emediarodetail();
		
		emediarodetail.setEmediarodetailid(emediarodetailDto.getEmediarodetailid());
		emediarodetail.setSrno(emediarodetailDto.getSrno());
		emediarodetail.setFromtodate(emediarodetailDto.getFromtodate());
		emediarodetail.setNoofdays(emediarodetailDto.getNoofdays());
		emediarodetail.setFromtime(emediarodetailDto.getFromtime());
		emediarodetail.setTotime(emediarodetailDto.getTotime());
		emediarodetail.setDailyspots(emediarodetailDto.getDailyspots());
		emediarodetail.setTotalspots(emediarodetailDto.getTotalspots());
		emediarodetail.setBonuspaid(emediarodetailDto.getBonuspaid());
		emediarodetail.setCharges(emediarodetailDto.getCharges());
		emediarodetail.setDuration(emediarodetailDto.getDuration());
		emediarodetail.setTotalcharges(emediarodetailDto.getTotalcharges());
		emediarodetail.setCaption(emediarodetailDto.getCaption());
		
		Emediarodetail saveEmediarodetail= emediarodetailService.save(emediarodetail);
		
		return new ResponseEntity<>(saveEmediarodetail,HttpStatus.CREATED);
		
	}
}
