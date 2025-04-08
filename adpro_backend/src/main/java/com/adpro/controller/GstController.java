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

import com.adpro.dto.GstDto;
import com.adpro.entity.Agency;
import com.adpro.entity.Gst;
import com.adpro.service.AgencyService;
import com.adpro.service.GstService;
@RestController
@RequestMapping("/Gsts")
@CrossOrigin
public class GstController {
	@Autowired
	private GstService gstService;
	
	@Autowired
	private AgencyService agencyService;
	
	@PostMapping("/")
	public ResponseEntity<Gst>save(@RequestBody GstDto gstDto){
		Gst gst= new Gst();
		
		Agency agency =agencyService.getById(gstDto.getAgencyid());
		gst.setAgency(agency);
		gst.setTitle(gstDto.getTitle());
		gst.setCgstpercent(gstDto.getCgstpercent());
		gst.setSgstpercent(gstDto.getSgstpercent());
		gst.setIgstpercent(gstDto.getIgstpercent());
		gst.setGstcode(gstDto.getGstcode());
		
		Gst savegst=gstService.save(gst);
		return new ResponseEntity<>(savegst,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Gst>>lists(){
		
		List<Gst> gst=gstService.lists();
		if(gst==null) {
			return new ResponseEntity<>(gst,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(gst,HttpStatus.FOUND);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Gst>getById(@PathVariable("id") int id){
		
		Gst gst= gstService.getById(id);
		if(gst==null) {
			return new ResponseEntity<>(gst,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(gst,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>deleteById(@PathVariable("id") int id){
		
		Gst gst= gstService.getById(id);
		if(gst==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Gst>upadte(@PathVariable("id") int id,@RequestBody GstDto gstDto){
		Gst gst= gstService.getById(id);
		if(gst==null) {
			return new ResponseEntity<>(gst,HttpStatus.NOT_FOUND);
		}
		
		Agency agency=agencyService.getById(gstDto.getAgencyid());
		gst.setAgency(agency);
		gst.setTitle(gstDto.getTitle());
		gst.setCgstpercent(gstDto.getCgstpercent());
		gst.setSgstpercent(gstDto.getSgstpercent());
		gst.setIgstpercent(gstDto.getIgstpercent());
		gst.setGstcode(gstDto.getGstcode());
		
		Gst Updatedgst=gstService.save(gst);
		return new ResponseEntity<>(Updatedgst,HttpStatus.CREATED);
	}

}
