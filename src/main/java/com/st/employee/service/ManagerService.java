package com.st.employee.service;

import java.util.List;
import com.st.employee.entity.Manager;
import com.st.employee.exception.AlreadyExistException;
import com.st.employee.exception.NoOneExistException;

public interface ManagerService {
	public Manager addManager(Manager manager) throws AlreadyExistException;

	public List<Manager> getlist();

	public List<Manager> searchbyCity(String loc) throws NoOneExistException;

	public Manager getById(int id) throws NoOneExistException;

	public void deletebyId(int id) throws NoOneExistException;

	public Manager updateManager(int id, Manager man) throws NoOneExistException;

}
