package services;

import java.util.ArrayList;
import java.util.List;

import models.Customer;

public class CustomerDataService {
	private List<Customer> customerList = new ArrayList<>();
	
	public static final CustomerDataService CUSTOMER_DATA_SERVICE = new CustomerDataService();
	
	private CustomerDataService() {}
	
	
	public String addCustomer(Customer customer) {
		int newId = customerList.size()+1;
		String idStr = Integer.toString(newId);
		customer.setId(idStr);
		customerList.add(customer);
		return idStr;
	}
	public String addCustomer(String name, String address, String phone) {
		Customer customer = new Customer();
		
		customer.setName(name);
		customer.setAddress(address);
		customer.setPhone(phone);
		return addCustomer(customer);
	}
	
	public Customer getCustomerById(String id) {
		
		for(Customer c : customerList) {
			if(c.getId().equals(id)){
				return c;
			}
		}
		return null;
	}
	
	public List<Customer> getCustomerList(){
		return customerList;
	}
}
