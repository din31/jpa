package jmp.orm.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jmp.orm.exception.EmployeeNotFoundException;
import jmp.orm.model.Employee;

@Repository
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	@Autowired
	 public SessionFactory sessionFactory;

	@Override
	public Employee addEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		Integer id = (Integer) session.save(employee);
		employee.setId(id);
		return employee;
	}

	@Override
	public List<Employee> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Employee").getResultList();
	}

	@Override
	public Employee findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Employee.class, id);
	}

	@Override
	public void deleteById(Integer id) {
		Employee emp = findById(id);
		if (emp == null)
		{
			throw new EmployeeNotFoundException();
		}
		Session session = sessionFactory.getCurrentSession();
		session.delete(emp);
	}

	@Override
	public void update(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.update(employee);
	}

}
