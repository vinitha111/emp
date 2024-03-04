package com.st.employee.srviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.employee.entity.Employee;
import com.st.employee.exception.AlreadyExistException;
import com.st.employee.exception.NoOneExistException;
import com.st.employee.repo.EmployeeRepo;
import com.st.employee.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
@Autowired	
EmployeeRepo repo;
	@Override
	public Employee addEmployee(Employee emp) throws AlreadyExistException {
		Optional<Employee> e = repo.findById(emp.getId());
		if(e.isEmpty()) {
			Employee employee = repo.save(emp);
			return employee;
		}
		else {
			throw new AlreadyExistException("Already existed with this id :"+emp.getId());
		}
	}

	@Override
	public List<Employee> getlist() {
          List<Employee> list = repo.findAll();
		return list;
	}

	@Override
	public List<Employee> searchbyCity(String loc) throws NoOneExistException {
              List<Employee> list = repo.findAll().stream().filter(e->e.getAddress().equals(loc)).collect(Collectors.toList());
              if(list.isEmpty()) {
            	  throw new NoOneExistException("No One Exist in this location");
              }
              else {
		return list;
	}
	}

	@Override
	public Employee getById(int id) throws NoOneExistException {
		Optional<Employee> e = repo.findById(id);
		if(e.isEmpty()) {
			throw new NoOneExistException("No One Exist with this id :"+id);
		}
		else {
		return e.get();
		}
		}

	@Override
	public void deletebyId(int id) throws NoOneExistException {
		Optional<Employee> e = repo.findById(id);
		if(e.isEmpty()) {
			throw new NoOneExistException("No One Exist with this id :"+id);
		}
		else {
			repo.deleteById(id);
		}
	}

	@Override
	public Employee updateEmployee(int id, Employee emp) throws NoOneExistException {
		Optional<Employee> em = repo.findById(id);
		if(em.isEmpty()) {
			throw new NoOneExistException("No One Exist with this id :"+id);
		}
		else {
	      Employee e=em.get();
	      e.setId(emp.getId());
	      e.setName(emp.getName());
	      e.setSalary(emp.getSalary());
	      e.setDept(emp.getDept());
	      e.setAddress(emp.getAddress());
	      repo.save(e);
		}
		return emp;
	}
		
	}


