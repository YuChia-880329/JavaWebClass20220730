package servers.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import models.Customer;
import servers.CustomerDataServer;

@Path("customers")
public class CustomerRestService {
	
	@GET
	@Path("one")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer() {
		Customer customer = new CustomerDataServer().getCustomer("Amy", 100, "23826015", "Taipei");
		return customer;
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	@Path("post")
	public Response getCustomerByForm(Customer customer) {
		String result = "Recorded : " + customer;
		return Response.ok().entity(result).build();
	}
}
