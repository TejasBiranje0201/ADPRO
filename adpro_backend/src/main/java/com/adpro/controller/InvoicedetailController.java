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

import com.adpro.dto.InvoicedetailDto;
import com.adpro.entity.Invoicedetail;
import com.adpro.service.InvoicedetailService;


@RestController
@RequestMapping("/invoicedetails")
@CrossOrigin
public class InvoicedetailController {
	
	@Autowired
	private InvoicedetailService invoicedetailService;
	
	@PostMapping("/")
	public ResponseEntity<Invoicedetail> save(@RequestBody InvoicedetailDto invoicedetailDto){
		
		Invoicedetail invoicedetail= new Invoicedetail();
		
		invoicedetail.setInvoiceid(invoicedetailDto.getInvoiceid());
		invoicedetail.setSrno(invoicedetailDto.getSrno());
		invoicedetail.setName(invoicedetailDto.getName());
		invoicedetail.setDescription(invoicedetailDto.getDescription());
		invoicedetail.setQuantity(invoicedetailDto.getQuantity());
		invoicedetail.setRate(invoicedetailDto.getRate());
		invoicedetail.setAmount(invoicedetailDto.getAmount());
		 
		Invoicedetail updatedinvoice=invoicedetailService.save(invoicedetail);
		
		return new ResponseEntity<>(updatedinvoice,HttpStatus.CREATED);
	}
	@GetMapping("/")
	public ResponseEntity<List<Invoicedetail>>list(){
		
		List<Invoicedetail> invoicedetail=invoicedetailService.lists();
		
		if(invoicedetail==null) {
			return new ResponseEntity<>(invoicedetail,HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<>(invoicedetail,HttpStatus.OK);
		
	}
	@GetMapping("/{id}")
	
	public ResponseEntity<Invoicedetail>getById(@PathVariable("id") int id){
		
		Invoicedetail invoicedetail=invoicedetailService.getById(id);
		
		if(invoicedetail==null) {
			return new ResponseEntity<>(invoicedetail,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(invoicedetail,HttpStatus.OK);
		}
	
	@DeleteMapping("/{id}")
	
public ResponseEntity<Void>deleteById(@PathVariable("id") int id){
		
		Invoicedetail invoicedetail= invoicedetailService.getById(id);
		if(invoicedetail==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
		
}
	@PutMapping("/{id}")
	public ResponseEntity<Invoicedetail> update(@PathVariable("id") int id,@RequestBody InvoicedetailDto invoicedetailDto){
		
		Invoicedetail invoicedetail=invoicedetailService.getById(id);
		
		if(invoicedetail==null) {
			return new ResponseEntity<>(invoicedetail,HttpStatus.NOT_FOUND);
		}
		
		invoicedetail.setInvoiceid(invoicedetailDto.getInvoiceid());
		invoicedetail.setSrno(invoicedetailDto.getSrno());
		invoicedetail.setName(invoicedetailDto.getName());
		invoicedetail.setDescription(invoicedetailDto.getDescription());
		invoicedetail.setQuantity(invoicedetailDto.getQuantity());
		invoicedetail.setRate(invoicedetailDto.getRate());
		invoicedetail.setAmount(invoicedetailDto.getAmount());
		
		Invoicedetail updatedinvoice=invoicedetailService.save(invoicedetail);
		
		return new ResponseEntity<>(updatedinvoice,HttpStatus.CREATED);
	}
	
}
