package models;

public class Customer {
	private String name;
	private int id;
	private String phone;
	private String city;
	
	
	public Customer() {
	}
	public Customer(String name, int id, String phone, String city) {
		this.name = name;
		this.id = id;
		this.phone = phone;
		this.city = city;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", id=" + id + ", phone=" + phone + ", city=" + city + "]";
	}
	
	
}
