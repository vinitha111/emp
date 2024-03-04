package com.st.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.employee.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

}
