package com.st.employee.service;

import java.util.List;
import com.st.employee.entity.Department;
import com.st.employee.exception.AlreadyExistException;
import com.st.employee.exception.NoOneExistException;

public interface DepartmentService {
	public Department addDepartment(Department dept) throws AlreadyExistException;

	public List<Department> getlist();
	
	public Department getById(int id) throws NoOneExistException;

	public void deletebyId(int id) throws NoOneExistException;

	public Department updateDepartment(int id, Department dept) throws NoOneExistException;

}
