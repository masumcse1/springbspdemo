package com.wss.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wss.model.Employee;
import com.wss.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public Employee getEmployeeById(long employeeid) {
		Optional<Employee> optionalEmp = employeeRepository.findById(employeeid);
		return optionalEmp.get();
	
	}

}
