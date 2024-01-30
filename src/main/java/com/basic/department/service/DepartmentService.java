package com.basic.department.service;

import java.util.List;

import com.basic.department.entity.Department;
import com.basic.department.error.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentbyId(Long departmentId) throws DepartmentNotFoundException;

	public void deleteDepartmentById(Long departmentId);

	public Department updateDepartment(Long departmentId, Department department);

	public String fetchDepartmentByName(String departmentName);

}
