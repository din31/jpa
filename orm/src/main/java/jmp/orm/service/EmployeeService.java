package jmp.orm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jmp.orm.model.Employee;
import jmp.orm.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepository;

	public Employee createEmployee(Employee employee) {
		return empRepository.addEmployee(employee);
	}

	public Employee findById(Integer id)
	{
		return empRepository.findById(id);
	}
	
	public void deleteById(Integer id)
	{
		empRepository.deleteById(id);
	}
	
	public void update(Employee employee)
	{
		empRepository.update(employee);
	}
	
	public List<Employee> getAll()
	{
		return empRepository.getAll();
	}
}
