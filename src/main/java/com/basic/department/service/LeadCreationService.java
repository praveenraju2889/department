package com.basic.department.service;

import java.util.List;

import com.basic.department.entity.LeadCreation;

public interface LeadCreationService {
	
	


	public LeadCreation createLead(LeadCreation leadCreation);

	public List<LeadCreation> getLead();
}
