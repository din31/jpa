package jmp.orm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jmp.orm.model.Employee;
import jmp.orm.model.Unit;
import jmp.orm.repository.UnitRepository;

@Service
public class UnitService {
	
	@Autowired
	private UnitRepository unitRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	public Unit createUnit(Unit unit)
	{
		return unitRepository.addUnit(unit);
	}
	
	public Unit findById(Integer id)
	{
		return unitRepository.findById(id);
	}
	
	public void deleteById(Integer id)
	{
		unitRepository.deleteById(id);
	}
	
	public void update(Unit unit)
	{
		unitRepository.update(unit);
	}
	
	public void addEmployee(Integer unitId, Integer employeeid)
	{
		Employee emp = employeeService.findById(employeeid);
		unitRepository.addEmployee(unitId, emp);
	}

	public List<Unit> getAll()
	{
		return unitRepository.getAll();
	}
}
