package restServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hi")
public class HelloWorldRestService {

	@GET
	@Produces(MediaType.TEXT_PLAIN + ";charset=utf8")
	public String getHelloMsg() {
		return "Hi 您好!";
	}
}
