package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="suppliers")
public class Supplier {
	
	@Id
	@Column(name="SUP_ID")
	private int id;
	@Column(name="SUP_NAME")
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	public Supplier() {}
	public Supplier(int id, String name, String street, String city, String state, String zip) {
		this.id = id;
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", zip=" + zip + "]";
	}
	
	
	
}
