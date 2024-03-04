package com.st.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.employee.entity.Manager;

@Repository
public interface ManagerRepo extends JpaRepository<Manager,Integer> {

}
