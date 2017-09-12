package cn.employee.service;

import java.util.List;


import cn.employee.model.Employee;


public interface EmployeeService {

	public Employee login(Employee employee);
    public int findByUsername(String username);
	public List<Employee> findAll();


	
	
}
