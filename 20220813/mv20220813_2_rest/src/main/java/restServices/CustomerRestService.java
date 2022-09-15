package restServices;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import models.Customer;
import services.CustomerDataService;

@Path("/customers")
public class CustomerRestService {
	
	private CustomerDataService dataService = CustomerDataService.CUSTOMER_DATA_SERVICE;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getCustomers(){
		return dataService.getCustomerList();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String createCustomer(@FormParam("name")String name,
			@FormParam("address")String address,
			@FormParam("phone-number")String phone) {
		return dataService.addCustomer(name, address, phone);
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomer(@PathParam("id")String id) {
		Customer customer = dataService.getCustomerById(id);
		if (customer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok().entity(customer).build();
        }

	}
	

	@GET
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postStudentRecord(Customer customer) {
		String result = "Record entered:" + customer;
		return Response.ok().entity(result).build();
	}
}
