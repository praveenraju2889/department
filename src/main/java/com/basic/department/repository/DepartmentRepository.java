package com.basic.department.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basic.department.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	public Department findByDepartmentName(String departmentName);
	public List<Department> findAllByDepartmentNameIgnoreCase(String departmentName);

}
