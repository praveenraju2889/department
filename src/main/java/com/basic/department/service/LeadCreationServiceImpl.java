package com.basic.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.department.entity.LeadCreation;
import com.basic.department.repository.LeadCreationRepository;

@Service
public class LeadCreationServiceImpl implements LeadCreationService{

	@Autowired
	private LeadCreationRepository leadCreationRepository;

	@Override
	public LeadCreation createLead(LeadCreation leadCreation) {
		// TODO Auto-generated method stub
		return leadCreationRepository.save(leadCreation);
	}

	@Override
	public List<LeadCreation> getLead() {
		// TODO Auto-generated method stub
		return leadCreationRepository.findAll();
	}


	
	

}
