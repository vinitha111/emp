package com.st.employee.service;

import java.util.List;
import com.st.employee.entity.Employee;
import com.st.employee.exception.AlreadyExistException;
import com.st.employee.exception.NoOneExistException;



public interface EmployeeService {
	public Employee addEmployee(Employee employee) throws AlreadyExistException;

	public List<Employee> getlist();

	public List<Employee> searchbyCity(String loc) throws NoOneExistException;

	public Employee getById(int id) throws NoOneExistException;

	public void deletebyId(int id) throws NoOneExistException;

	public Employee updateEmployee(int id, Employee emp) throws NoOneExistException;

}
