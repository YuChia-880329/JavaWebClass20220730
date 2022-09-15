package servers.rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import models.User;

@Path("users")
public class UserRestService {
	
	
	@POST
	@Path("/post")
	public Response getUser(User user) {
		
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("mv20220827_1");
			EntityManager em = emf.createEntityManager();
			EntityTransaction transaction = em.getTransaction();
			
			transaction.begin();
			em.persist(user);
			transaction.commit();
			em.close();
			emf.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		
		
		String result = "Recorded : " + user;
		return Response.ok().entity(result).build();
	}
}
