package jmp.orm.repository;

import java.util.List;

import jmp.orm.model.Employee;

public interface EmployeeRepository {
	
	Employee addEmployee(Employee employee);
	
	List<Employee> getAll();
	
	Employee findById(Integer id);

	void deleteById(Integer id);
	
	void update(Employee employee);
}
