package jmp.orm.repository;

import java.util.List;

import jmp.orm.model.Employee;
import jmp.orm.model.Unit;

public interface UnitRepository {
	
	Unit addUnit(Unit unit);

	List<Unit> getAll();

	Unit findById(Integer id);

	void deleteById(Integer id);

	void update(Unit unit);
	
	void addEmployee(Integer unitId, Employee employee);
}
