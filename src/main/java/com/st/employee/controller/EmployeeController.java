package com.st.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.employee.entity.Employee;
import com.st.employee.exception.AlreadyExistException;
import com.st.employee.exception.NoOneExistException;
import com.st.employee.service.EmployeeService;

@RestController
@RequestMapping("/api1")
public class EmployeeController {
	@Autowired
	private  EmployeeService empser;
//	@PostMapping("/add")
//	public ResponseEntity<Student> savestudent(@RequestBody Student sttd) throws AlreadyExistsException {
//		Student savest=stuser.addStudent(sttd);
//		return new ResponseEntity<>(savest,HttpStatus.CREATED);
//		
//	}
	@PostMapping("/employee/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emtd) throws AlreadyExistException {
		Employee employee = empser.addEmployee(emtd);
		return new ResponseEntity<>(employee,HttpStatus.CREATED);
		
	}

	@GetMapping("/employee/list")
	public ResponseEntity<List<Employee>> getList() {
		return new ResponseEntity<>(empser.getlist(), HttpStatus.OK);
	}

	@GetMapping("/employee/list/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) throws NoOneExistException {
		Employee emp = empser.getById(id);
		
			return new ResponseEntity<>(emp,HttpStatus.NOT_FOUND);
		

	}

	@GetMapping("/employee/search/{loc}")
	public ResponseEntity<List<Employee>> searchbyCity(@PathVariable String loc) throws  NoOneExistException {
		List<Employee> e = empser.searchbyCity(loc);
		if (e.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(e, HttpStatus.OK);
		}
	}

	@PutMapping("/employee/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee emp)
			throws AlreadyExistException, NoOneExistException {
		Employee e =empser.updateEmployee(id,emp);

					return new ResponseEntity<>(/* stuser.addStudent(st.get()), */e, HttpStatus.OK);

		
	}

	@DeleteMapping("/employee/del/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id) throws NoOneExistException {
	      	
			empser.deletebyId(id);
			return new ResponseEntity<>(HttpStatus.OK);

	}

}
