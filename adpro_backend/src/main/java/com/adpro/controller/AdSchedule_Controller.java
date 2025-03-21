package com.adpro.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adpro.dto.AdSchedule_Dto;
import com.adpro.entity.AdSchedules;
import com.adpro.entity.Agency;
import com.adpro.entity.Client;
import com.adpro.entity.P_medias;
import com.adpro.entity.Pmedia_ROs;
import com.adpro.service.AdSchedule_Service;
import com.adpro.service.AgencyService;
import com.adpro.service.ClientService;
import com.adpro.service.P_mediasService;
import com.adpro.service.Pmedia_ROsService;

@RestController
@RequestMapping("/adschedule")
public class AdSchedule_Controller {
	
	@Autowired
	private AdSchedule_Service adSchedule_Service;
	
	@Autowired
	private AgencyService agencyService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private P_mediasService p_mediasService;
	
	@Autowired
	private Pmedia_ROsService pmedia_ROsService;
	
	
	@GetMapping("/")
	public ResponseEntity<List<AdSchedules>> getAllAdSchedules(){
		
		List<AdSchedules> adSchedules = adSchedule_Service.getAll();
		
		return new ResponseEntity<>(adSchedules,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AdSchedules> getAllAdById(@PathVariable int id){
		
		AdSchedules adSchedules = adSchedule_Service.getById(id);
		
		return new ResponseEntity<AdSchedules>(adSchedules,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<AdSchedules> saveAdSchedule(@RequestBody AdSchedule_Dto adSchedule_Dto){
		
		AdSchedules adSchedules = new AdSchedules();
		
		adSchedules.setAdDate(adSchedule_Dto.getAdDate());
		adSchedules.setDescription(adSchedule_Dto.getDescription());
		adSchedules.setBeforeClientMessage(adSchedule_Dto.getBeforeClientMessage());
		adSchedules.setBeforeAgencyMessage(adSchedule_Dto.getBeforeAgencyMessage());
		adSchedules.setOnDateAgencyMessage(adSchedule_Dto.getOnDateAgencyMessage());
		adSchedules.setOnDateClientMessage(adSchedule_Dto.getOnDateClientMessage());
		
		Agency agency = agencyService.getById(adSchedule_Dto.getAgencyId());
		adSchedules.setAgency(agency);
		
		Client client = clientService.getById(adSchedule_Dto.getClientId());
		adSchedules.setClient(client);
		
		P_medias p_medias = p_mediasService.getById(adSchedule_Dto.getPmediaId());
		adSchedules.setP_medias(p_medias);
		
		Pmedia_ROs pmedia_ROs = pmedia_ROsService.getById(adSchedule_Dto.getPmediaRoId());
		adSchedules.setPmedia_ROs(pmedia_ROs);
		
		AdSchedules saveAdSchedules = adSchedule_Service.save(adSchedules);
		
		
		return new ResponseEntity<AdSchedules>(saveAdSchedules,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AdSchedules> updateAdSchedule(@PathVariable int id, @RequestBody AdSchedule_Dto adSchedule_Dto){
		
		AdSchedules existingAdSchedules = adSchedule_Service.getById(id);
		
		if(existingAdSchedules == null) {
			
			return new ResponseEntity<>(existingAdSchedules,HttpStatus.NOT_FOUND);
		}
		
		existingAdSchedules.setAdDate(adSchedule_Dto.getAdDate());
		existingAdSchedules.setDescription(adSchedule_Dto.getDescription());
		existingAdSchedules.setBeforeClientMessage(adSchedule_Dto.getBeforeClientMessage());
		existingAdSchedules.setBeforeAgencyMessage(adSchedule_Dto.getBeforeAgencyMessage());
		existingAdSchedules.setOnDateAgencyMessage(adSchedule_Dto.getOnDateAgencyMessage());
		existingAdSchedules.setOnDateClientMessage(adSchedule_Dto.getOnDateClientMessage());
		
		Agency agency = agencyService.getById(adSchedule_Dto.getAgencyId());
		existingAdSchedules.setAgency(agency);
		
		Client client = clientService.getById(adSchedule_Dto.getClientId());
		existingAdSchedules.setClient(client);
		
		P_medias p_medias = p_mediasService.getById(adSchedule_Dto.getPmediaId());
		existingAdSchedules.setP_medias(p_medias);
		
		Pmedia_ROs pmedia_ROs = pmedia_ROsService.getById(adSchedule_Dto.getPmediaRoId());
		existingAdSchedules.setPmedia_ROs(pmedia_ROs);
		
		AdSchedules updatAdSchedules = adSchedule_Service.save(existingAdSchedules);
		
		
		return new ResponseEntity<AdSchedules>(updatAdSchedules,HttpStatus.OK);
	}
	
	public ResponseEntity<Void> deleteAdSchedule(@PathVariable int id){
		
		adSchedule_Service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
