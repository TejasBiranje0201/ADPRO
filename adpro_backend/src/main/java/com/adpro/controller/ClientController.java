package com.adpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.reactive.ReactiveResourceSynchronization;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adpro.dto.ClientDto;
import com.adpro.entity.Agency;
import com.adpro.entity.Client;
import com.adpro.entity.State;
import com.adpro.service.AgencyService;
import com.adpro.service.ClientService;
import com.adpro.service.StateService;

@RestController
@RequestMapping("/client")
@CrossOrigin
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	@Autowired
	private StateService stateService;
	@Autowired
	private AgencyService agencyService;
	
	@PostMapping("/")
	public ResponseEntity<Client> save(@RequestBody ClientDto clientDto){
		
		Client client= new Client();
		Agency agency=agencyService.getById(clientDto.getAgencyId());
		client.setAgency(agency);
		client.setName(clientDto.getName());
		client.setContact(clientDto.getContact());
		client.setAddress(clientDto.getAddress());
		State state = stateService.getByid(clientDto.getStateId());
		client.setState(state);
		client.setGstno(clientDto.getGstno());
		
		Client savedclient=clientService.save(client);
		
		return new ResponseEntity<>(savedclient,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Client>>list(){
		List<Client> clients = clientService.list();
		if(clients==null) {
			return new ResponseEntity<>(clients,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(clients,HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client>getByid(@PathVariable("id") int id){
		
		Client client= clientService.getById(id);
		
		if(client== null) {
			return new ResponseEntity<>(client,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(client,HttpStatus.FOUND);
		
		}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>deleteById(@PathVariable("id") int id){
		
		Client cilent= clientService.getById(id);
		if(cilent==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client>update(@PathVariable("id") int id,@RequestBody ClientDto clientDto){
		Client client=clientService.getById(id);
		
		if(client==null) {
			return new ResponseEntity<>(client,HttpStatus.NOT_FOUND);
		}
		Agency agency=agencyService.getById(clientDto.getAgencyId());
		client.setAgency(agency);
		client.setName(clientDto.getName());
		client.setContact(clientDto.getContact());
		client.setAddress(clientDto.getAddress());
		State state = stateService.getByid(clientDto.getStateId());
		client.setState(state);
		client.setGstno(clientDto.getGstno());
		
		Client updatedclient=clientService.save(client);
		
		return new ResponseEntity<>(updatedclient,HttpStatus.CREATED);
		
	}
	
	
	

}
