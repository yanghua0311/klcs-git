package cn.employee.mapper;

import java.util.List;

import cn.employee.model.Department;

public interface DepartmentMapper {

	int findCount();

 	List<Department> findByPage(int begin, int pageSize);

	public void save(Department department);

	Department findById(int did);



	void update(Department department);


	void delete(Department department);

	List<Department> findDept();

}
