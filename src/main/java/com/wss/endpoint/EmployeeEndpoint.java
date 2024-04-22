package com.wss.endpoint;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.wss.gen.AddEmployeeRequest;
import com.wss.gen.AddEmployeeResponse;
import com.wss.gen.Employeeinfo;
import com.wss.gen.GetEmployeeByIDRequest;
import com.wss.gen.GetEmployeeByIDResponse;
import com.wss.gen.Servicestatus;
import com.wss.model.Employee;
import com.wss.service.EmployeeService;

@Endpoint
public class EmployeeEndpoint {

	private static final String NAMESPACE_URI = "http://com.springbootsoap.allapis";

	@Autowired
	private EmployeeService employeeService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmployeeRequest")
	@ResponsePayload
	public AddEmployeeResponse addEmpoyee(@RequestPayload AddEmployeeRequest request) {

		AddEmployeeResponse response = new AddEmployeeResponse();
		Servicestatus status = new Servicestatus();

		Employee employee = new Employee();
		BeanUtils.copyProperties(request.getEmployeeinfo(), employee);
		employeeService.addEmployee(employee);

		status.setStatus("SUCCESS");
		status.setMessage("Employee data save successfully");
		response.setServicestatus(status);
		System.out.println("------------addEmpoyee------save data ");
		return response;
	}
	

	 @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeByIDRequest")
    @ResponsePayload
	public GetEmployeeByIDResponse getEmployee(@RequestPayload GetEmployeeByIDRequest request) {

		GetEmployeeByIDResponse response = new GetEmployeeByIDResponse();
		Employee employee = employeeService.getEmployeeById(request.getEmployeeid());
		
		Employeeinfo employeeinfo = new Employeeinfo();
		BeanUtils.copyProperties(employee, employeeinfo);
		employeeService.addEmployee(employee);

		response.setEmployeeinfo(employeeinfo);
		System.out.println("------------getEmployee------save data ");
		return response;
	}

}
