package jmp.orm.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jmp.orm.exception.ProjectNotFoundException;
import jmp.orm.model.Employee;
import jmp.orm.model.Project;

@Repository
@Transactional
public class ProjectRepositoryImpl implements ProjectRepository{
	
	@Autowired
	 public SessionFactory sessionFactory;

	@Override
	public Project addProject(Project project) {
		Session session = sessionFactory.getCurrentSession();
		Integer id = (Integer) session.save(project);
		project.setId(id);
		return project;
	}

	@Override
	public List<Project> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Project").getResultList();
	}

	@Override
	public Project findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Project.class, id);
	}

	@Override
	public void deleteById(Integer id){
		Project pr = findById(id);
		if (pr == null)
		{
			throw new ProjectNotFoundException();
		}
		Session session = sessionFactory.getCurrentSession();
		session.delete(pr);
	}

	@Override
	public void update(Project project) {
		Session session = sessionFactory.getCurrentSession();
		session.update(project);
	}

	@Override
	public void assignEmployee(Integer projectId, Employee employee){
		Session session = sessionFactory.getCurrentSession();
		Project pr = findById(projectId);
		if (pr == null)
		{
			throw new ProjectNotFoundException();
		}
		pr.addEmployee(employee);
		session.save(pr);	
	}
}
