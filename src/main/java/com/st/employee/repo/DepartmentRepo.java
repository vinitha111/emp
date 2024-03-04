package com.st.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.employee.entity.Department;
@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer> {

}
