package jmp.orm.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Unit {
	
	@Id
	@GeneratedValue
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy = "unit", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<Employee> employees = new HashSet<>();
	
	public Unit() {}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	public void addEmployee(Employee emp)
	{
		employees.add(emp);
	}
	
	public String toString()
	{
		return String.format("[id=%s empCount=%s]", id, employees.size());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Unit))
		{
			return false;
		}
		Unit other = (Unit) obj;
		return id.equals(other.id);
	}
}
