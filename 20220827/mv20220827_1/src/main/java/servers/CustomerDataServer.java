package servers;

import models.Customer;

public class CustomerDataServer {
	public Customer getCustomer(String name, int id, String phone, String city) {
		return new Customer(name, id, phone, city);
	}
}
