package com.basic.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basic.department.entity.LeadCreation;

@Repository
public interface LeadCreationRepository extends JpaRepository<LeadCreation, Long > {

}
