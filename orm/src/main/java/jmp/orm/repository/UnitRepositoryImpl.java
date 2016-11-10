package jmp.orm.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jmp.orm.exception.UnitNotFoundException;
import jmp.orm.model.Employee;
import jmp.orm.model.Unit;

@Repository
@Transactional
public class UnitRepositoryImpl implements UnitRepository {
	
	@Autowired
	 public SessionFactory sessionFactory;

	@Override
	public Unit addUnit(Unit unit) {
		Session session = sessionFactory.getCurrentSession();
		Integer id = (Integer) session.save(unit);
		unit.setId(id);
		return unit;
	}

	@Override
	public List<Unit> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Unit").getResultList();
	}

	@Override
	public Unit findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Unit.class, id);
	}

	@Override
	public void deleteById(Integer id) {
		Unit unit = findById(id);
		if (unit == null)
		{
			throw new UnitNotFoundException();
		}
		Session session = sessionFactory.getCurrentSession();
		session.delete(unit);
	}

	@Override
	public void update(Unit unit) {
		Session session = sessionFactory.getCurrentSession();
		session.update(unit);
	}
	
	@Override
	public void addEmployee(Integer unitId, Employee employee) throws UnitNotFoundException {
		Unit unit = findById(unitId);
		if (unit == null)
		{
			throw new UnitNotFoundException();
		}
		unit.addEmployee(employee);
		sessionFactory.getCurrentSession().save(unit);
	}
}
