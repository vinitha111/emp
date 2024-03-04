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

import com.st.employee.entity.Department;
import com.st.employee.exception.AlreadyExistException;
import com.st.employee.exception.NoOneExistException;
import com.st.employee.service.DepartmentService;

@RestController
@RequestMapping("/api1")
public class DepartmentController {
	@Autowired
	private DepartmentService depser;
	
//	@PostMapping("/add")
//	public ResponseEntity<Student> savestudent(@RequestBody Student sttd) throws AlreadyExistsException {
//		Student savest=stuser.addStudent(sttd);
//		return new ResponseEntity<>(savest,HttpStatus.CREATED);
//		
//	}
	@PostMapping("/department/save")
	public void saveDepartment(@RequestBody Department dtd) throws AlreadyExistException {
		depser.addDepartment(dtd);
	}

	@GetMapping("/department/list")
	public ResponseEntity<List<Department>> getList() {
		return new ResponseEntity<>(depser.getlist(), HttpStatus.OK);
	}

	@GetMapping("/department/list/{id}")
	public ResponseEntity<Department> getDepartment(@PathVariable int id) throws NoOneExistException {
		Department emp = depser.getById(id);
		
			return new ResponseEntity<>(emp,HttpStatus.NOT_FOUND);

	}
	
	@PutMapping("/department/update/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable int id, @RequestBody Department dept)
			throws AlreadyExistException, NoOneExistException {
		Department d =depser.updateDepartment(id,dept);

					return new ResponseEntity<>(/* stuser.addStudent(st.get()), */d, HttpStatus.OK);

		
	}

	@DeleteMapping("/department/del/{id}")
	public ResponseEntity<Void> deleteDepartment(@PathVariable int id) throws NoOneExistException {
	      	
			depser.deletebyId(id);
			return new ResponseEntity<>(HttpStatus.OK);

	}

}
