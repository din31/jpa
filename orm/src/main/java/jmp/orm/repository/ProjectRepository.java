package jmp.orm.repository;

import java.util.List;

import jmp.orm.exception.ProjectNotFoundException;
import jmp.orm.model.Employee;
import jmp.orm.model.Project;

public interface ProjectRepository {

	Project addProject(Project project);

	List<Project> getAll();

	Project findById(Integer id);

	void deleteById(Integer id);

	void update(Project project);
	
	void assignEmployee(Integer projectId, Employee employee);
}
