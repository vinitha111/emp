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

import com.st.employee.entity.Manager;
import com.st.employee.exception.AlreadyExistException;
import com.st.employee.exception.NoOneExistException;
import com.st.employee.service.ManagerService;



@RestController
@RequestMapping("/api1")
public class ManagerController {
	@Autowired
	private ManagerService manser;
//	@PostMapping("/add")
//	public ResponseEntity<Student> savestudent(@RequestBody Student sttd) throws AlreadyExistsException {
//		Student savest=stuser.addStudent(sttd);
//		return new ResponseEntity<>(savest,HttpStatus.CREATED);
//		
//	}
	@PostMapping("/manager/save")
	public void saveManager(@RequestBody Manager mtd) throws AlreadyExistException {
		manser.addManager(mtd);
	}

	@GetMapping("/manager/list")
	public ResponseEntity<List<Manager>> getList() {
		return new ResponseEntity<>(manser.getlist(), HttpStatus.OK);
	}

	@GetMapping("/manager/list/{id}")
	public ResponseEntity<Manager> getManager(@PathVariable int id) throws NoOneExistException {
		Manager man = manser.getById(id);
		
			return new ResponseEntity<>(man,HttpStatus.NOT_FOUND);
		

	}

	@GetMapping("/manager/search/{loc}")
	public ResponseEntity<List<Manager>> searchbyCity(@PathVariable String loc) throws  NoOneExistException {
		List<Manager> e = manser.searchbyCity(loc);
		if (e.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(e, HttpStatus.OK);
		}
	}

	@PutMapping("/manager/update/{id}")
	public ResponseEntity<Manager> updateManager(@PathVariable int id, @RequestBody Manager man)
			throws AlreadyExistException, NoOneExistException {
		Manager m =manser.updateManager(id,man);

					return new ResponseEntity<>(/* stuser.addStudent(st.get()), */m, HttpStatus.OK);

		
	}

	@DeleteMapping("/manager/del/{id}")
	public ResponseEntity<Void> deleteManager(@PathVariable int id) throws NoOneExistException {
	      	
			manser.deletebyId(id);
			return new ResponseEntity<>(HttpStatus.OK);

	}

}
