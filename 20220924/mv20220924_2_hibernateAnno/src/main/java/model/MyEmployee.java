package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_employee")
public class MyEmployee {
	@Id
	private int id;
	private String firstName;
	private String lastName;
	
	
	public MyEmployee() {
	}
	public MyEmployee(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	@Override
	public String toString() {
		return "MyEmployee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
