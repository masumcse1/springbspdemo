package com.wss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wss.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Employee findByemployeeid(long employeeid);
}
