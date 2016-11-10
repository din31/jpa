package jmp.orm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PersonalInfo {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String favouriteAnimal; 
	
	public PersonalInfo() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFavouriteAnimal() {
		return favouriteAnimal;
	}

	public void setFavouriteAnimal(String favouriteAnimal) {
		this.favouriteAnimal = favouriteAnimal;
	}
	
	@Override
	public String toString()
	{
		return String.format("[id=%s animal=%s]", id, favouriteAnimal);
	}
}
