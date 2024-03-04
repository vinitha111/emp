package com.st.employee.srviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.employee.entity.Manager;
import com.st.employee.exception.AlreadyExistException;
import com.st.employee.exception.NoOneExistException;
import com.st.employee.repo.ManagerRepo;
import com.st.employee.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService{
	@Autowired
	private ManagerRepo repo;

	@Override
	public Manager addManager(Manager man) throws AlreadyExistException {
		Optional<Manager> m = repo.findById(man.getId());
		if(m.isEmpty()) {
			Manager manager = repo.save(man);
			return manager;
		}
		else {
			throw new AlreadyExistException("Already existed with this id :"+man.getId());
		}
	}

	@Override
	public List<Manager> getlist() {
		 List<Manager> list = repo.findAll();
			return list;
	}

	@Override
	public List<Manager> searchbyCity(String loc) throws NoOneExistException {
        List<Manager> list = repo.findAll().stream().filter(m->m.getAddress().equals(loc)).collect(Collectors.toList());
        if(list.isEmpty()) {
      	  throw new NoOneExistException("No One Exist in this location");
        }
        else {
	return list;
}
	}

	@Override
	public Manager getById(int id) throws NoOneExistException {
		Optional<Manager> m = repo.findById(id);
		if(m.isEmpty()) {
			throw new NoOneExistException("No One Exist with this id :"+id);
		}
		else {
		return( m.get());
	}
	}

	@Override
	public void deletebyId(int id) throws NoOneExistException {
		Optional<Manager> m = repo.findById(id);
		if(m.isEmpty()) {
			throw new NoOneExistException("No One Exist with this id :"+id);
		}
		else {
			repo.deleteById(id);
		}
		
	}

	@Override
	public Manager updateManager(int id, Manager man) throws NoOneExistException {
		Optional<Manager> ma = repo.findById(id);
		if(ma.isEmpty()) {
			throw new NoOneExistException("No One Exist with this id :"+id);
		}
		else {
	      Manager m=ma.get();
	      m.setId(man.getId());
	      m.setName(man.getName());
	      m.setSalary(man.getSalary());
	      m.setDept(man.getDept());
	     m.setAddress(man.getAddress());
	      repo.save(m);
	      return m;
	}
		
	}
	
}
