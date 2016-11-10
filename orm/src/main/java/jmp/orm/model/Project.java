package jmp.orm.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToMany(mappedBy = "projects", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<Employee> employees = new HashSet<>();
	
	@Column
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Project() {}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addEmployee(Employee emp)
	{
		employees.add(emp);
	}
	
	@Override
	public String toString()
	{
		return String.format("[id=%s name=%s empCount=%s]", id, name, employees.size());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Project))
		{
			return false;
		}
		Project other = (Project) obj;
		return name.equals(other.name);
	}
}
