package com.basic.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.basic.department.entity.LeadCreation;
import com.basic.department.service.LeadCreationService;

@RestController
public class LeadCreationController {
	
	@Autowired
	private LeadCreationService leadCreationService;
	@PostMapping("/wi_create")
	public LeadCreation createLead(@RequestBody LeadCreation leadCreation) {
		
		return leadCreationService.createLead(leadCreation);
	}
	@GetMapping("/getWi")
	public List<LeadCreation> getLead() {
		
		return leadCreationService.getLead();
	}
	

}
