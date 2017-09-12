package cn.employee.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.employee.mapper.EmployeeMapper;
import cn.employee.model.Employee;
import cn.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl  implements EmployeeService {
	@Autowired
  private EmployeeMapper employeeMapper;
	@Override
	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
		return  employeeMapper.findByUsernameAndPassword(employee);
	}
	@Override
	public int findByUsername(String username) {
		// TODO Auto-generated method stub
		return employeeMapper.findByUsername(username);
	}
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return  employeeMapper.findAll();
	}



}
