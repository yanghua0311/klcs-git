package cn.employee.mapper;

import java.util.List;

import cn.employee.model.Employee;


public interface EmployeeMapper {



	public Employee findByUsernameAndPassword(Employee employee);
	public int findByUsername(String username);
	 
	public List<Employee> findAll();
	public List<Employee> findAll(int begin, int pageSize);

	public int findCount();

	public void save(Employee employee);

	public Employee findById(int eid);

	public void update(Employee employee);

	public void delete(Employee employee);
 
}
