package com.adpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adpro.service.AgencyService;

@RestController
@RequestMapping("/agency")
public class AgencyController {
	@Autowired
	private AgencyService agencyService;

}
