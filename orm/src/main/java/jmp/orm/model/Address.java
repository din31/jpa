package jmp.orm.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column
	private String city;
	
	@Column
	private String street;
	
	public Address() {}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	@Override
	public String toString()
	{
		return String.format("[city=%s, street=%s]", city, street);
	}
}
