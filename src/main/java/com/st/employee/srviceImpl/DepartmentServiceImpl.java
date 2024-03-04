package com.st.employee.srviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.employee.entity.Department;
import com.st.employee.exception.AlreadyExistException;
import com.st.employee.exception.NoOneExistException;
import com.st.employee.repo.DepartmentRepo;
import com.st.employee.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
DepartmentRepo repo;
	@Override
	public Department addDepartment(Department dept) throws AlreadyExistException {
		Optional<Department> d = repo.findById(dept.getId());
		if(d.isEmpty()) {
			Department dep = repo.save(dept);
			return dep;
		}
		else {
			throw new AlreadyExistException("Already existed with this id :"+dept.getId());
		}
	}

	@Override
	public List<Department> getlist() {
		 List<Department> list = repo.findAll();
			return list;
	}

	@Override
	public Department getById(int id) throws NoOneExistException {
		Optional<Department> d = repo.findById(id);
		if(d.isEmpty()) {
			throw new NoOneExistException("No One Exist with this id :"+id);
		}
		else {
		return d.get();
		}
	}

	@Override
	public void deletebyId(int id) throws NoOneExistException {
		Optional<Department> d = repo.findById(id);
		if(d.isEmpty()) {
			throw new NoOneExistException("No One Exist with this id :"+id);
		}
		else {
			repo.deleteById(id);
		}
		
	}

	@Override
	public Department updateDepartment(int id, Department dept) throws NoOneExistException {
		Optional<Department> dep = repo.findById(id);
		if(dep.isEmpty()) {
			throw new NoOneExistException("No One Exist with this id :"+id);
		}
		else {
	      Department d=dep.get();
	      d.setId(dept.getId());
	      d.setName(dept.getName());
	     
	      repo.save(d);
		}
		return dept;
	}
		
	}


