package jmp.orm.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.transaction.annotation.Transactional;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private EmployeeStatus status;

	@Embedded
	private Address address;

	@OneToOne(cascade = CascadeType.ALL)
	private PersonalInfo personalInfo = new PersonalInfo();

	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="employee_project", 
				joinColumns={@JoinColumn(name="employee_id")}, 
				inverseJoinColumns={@JoinColumn(name="project_id")})
	private Set<Project> projects;
	
	@ManyToOne
	private Unit unit;

	public Employee() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmployeeStatus getStatus() {
		return status;
	}

	public void setStatus(EmployeeStatus status) {
		this.status = status;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	
	public void addProject(Project project)
	{
		projects.add(project);
	}
	
	@Override
	public String toString()
	{
		return String.format("[id=%s name=%s status=%s address=%s personal=%s unit=%s projects=%s]",
				id, name, status, address, personalInfo, unit, projects);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Employee))
		{
			return false;
		}
		Employee other = (Employee) obj;
		return name.equals(other.name);
	}
}
