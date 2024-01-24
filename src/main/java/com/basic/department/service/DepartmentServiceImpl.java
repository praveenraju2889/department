package com.basic.department.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.basic.department.entity.Department;
import com.basic.department.error.DepartmentNotFoundException;
import com.basic.department.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}
	@Override
	public List<Department> fetchDepartmentList() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
		
	}
	@Override
	public Department fetchDepartmentbyId(Long departmentId) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Department> department = departmentRepository.findById(departmentId);
		
		if(!department.isPresent()) {
			throw new DepartmentNotFoundException("Department Not found");
		}
		return department.get();
	}
	@Override
	public void deleteDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(departmentId);
	}
	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		// TODO Auto-generated method stub
		Department depDB = departmentRepository.findById(departmentId).get();
		if(Objects.nonNull(department.getDepartmentName())) {
			depDB.setDepartmentName(department.getDepartmentName());
		}
		if(Objects.nonNull(department.getDepartmentCode())) {
			depDB.setDepartmentCode(department.getDepartmentCode());
		}
		if(Objects.nonNull(department.getDepartmentAddress())) {
			depDB.setDepartmentAddress(department.getDepartmentAddress());
		}
		return departmentRepository.save(depDB);
	}
	@Override
	public Department fetchDepartmentByName(String departmentName) {
		// TODO Auto-generated method stub
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}
	
	
	
	

}
