package jmp.orm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jmp.orm.model.Employee;
import jmp.orm.model.Project;
import jmp.orm.repository.ProjectRepository;

@Service
public class ProjectService{
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private EmployeeService empService;

	public Project createProject(Project project)
	{
		return projectRepository.addProject(project);
	}
	
	public Project findById(Integer id)
	{
		return projectRepository.findById(id);
	}
	
	public void deleteById(Integer id)
	{
		projectRepository.deleteById(id);
	}
	
	public void update(Project project)
	{
		projectRepository.update(project);
	}
	
	public void assignEmployee(Integer projectId, Integer employeeId)
	{
		Employee emp = empService.findById(employeeId);
		projectRepository.assignEmployee(projectId, emp);
	}
	
	public List<Project> getAll()
	{
		return projectRepository.getAll();
	}
	
}
