package jmp.orm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import jmp.orm.model.Employee;
import jmp.orm.model.EmployeeStatus;
import jmp.orm.model.PersonalInfo;
import jmp.orm.model.Project;
import jmp.orm.model.Unit;
import jmp.orm.service.EmployeeService;
import jmp.orm.service.ProjectService;
import jmp.orm.service.UnitService;

public class Test {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UnitService unitService;
	
	public void test()
	{
		testEmployee();
		testProject();
		testUnit();
	}
	
	private void testEmployee()
	{
		System.out.println("Employee test...");
		Employee emp = new Employee();
        emp.setName("Harry");
        emp.setStatus(EmployeeStatus.SICK);
        Employee savedEmp = employeeService.createEmployee(emp);
        Assert.notNull(savedEmp);
        Assert.notNull(savedEmp.getId());
        Employee found = employeeService.findById(savedEmp.getId());
        Assert.notNull(found);
        found.getPersonalInfo().setFavouriteAnimal("fox");
        employeeService.update(found);
        Employee updated = employeeService.findById(savedEmp.getId());
        Assert.notNull(updated.getPersonalInfo().getFavouriteAnimal());
        employeeService.deleteById(savedEmp.getId());
        List<Employee> empList = employeeService.getAll();
        Assert.isTrue(empList.isEmpty());
        System.out.println("Employee test passed");
	}
	
	private void testProject()
	{
		System.out.println("Project test...");
		Employee ron = new Employee();
		ron.setName("Ron");
		ron.setStatus(EmployeeStatus.AVAILABLE);
        ron = employeeService.createEmployee(ron);
        Project amazingProject = new Project();
        amazingProject.setName("amazingProject");
        amazingProject = projectService.createProject(amazingProject);
        Assert.notNull(amazingProject.getId());
        Assert.isTrue(amazingProject.getEmployees().isEmpty());
        projectService.assignEmployee(amazingProject.getId(), ron.getId());
        Project updatedProject = projectService.findById(amazingProject.getId());
        Assert.notNull(updatedProject);      
        projectService.deleteById(amazingProject.getId());
        List<Employee> employees = employeeService.getAll();
        List<Project> projects = projectService.getAll();
        Assert.notEmpty(employees);
        Assert.isTrue(projects.isEmpty());
		System.out.println("Project test passed");
	}
	
	private void testUnit()
	{
		System.out.println("Unit test...");
		Employee hermione = new Employee();
		hermione.setName("Hermione");
		hermione.setStatus(EmployeeStatus.ON_VACATION);
		hermione = employeeService.createEmployee(hermione);
		Unit unit = new Unit();
		unit = unitService.createUnit(unit);
		Assert.notNull(unit.getId());
		Assert.isTrue(unit.getEmployees().isEmpty());
		unitService.addEmployee(unit.getId(), hermione.getId());
		Unit updatedUnit = unitService.findById(unit.getId());
		unitService.deleteById(unit.getId());
		Assert.isNull(unitService.findById(unit.getId()));
		Assert.notEmpty(employeeService.getAll());
		System.out.println("Unit test passed");
	}

}
