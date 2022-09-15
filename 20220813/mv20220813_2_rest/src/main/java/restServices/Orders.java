package restServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/orders")
public class Orders {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN + ";charset=utf8")
	public String getOrders() {
		return "returning all orders";
	}
	
	@GET
	@Path("/{orderId}")
	public String getOrderById(@PathParam("orderId")String id) {
		return "returning order by id " + id;
	}
	
	@GET
	@Path("/{orderId}/items")
	public String getOrderItems(@PathParam("orderId")String id) {
		return "returning all order items by id " + id;
	}
	
	@GET
	@Path("/{orderId}/items/{itemName}")
	public String getOrderItemByName(@PathParam("orderId")String id,
			@PathParam("itemName")String name) {
		
		return "returning order " + id + "'s item by name " + name;
	}
}
