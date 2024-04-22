package com.wss.service;

import com.wss.model.Employee;

public interface EmployeeService {
	
	void addEmployee(Employee  employee);
	
	Employee getEmployeeById(long employeeid);

}
