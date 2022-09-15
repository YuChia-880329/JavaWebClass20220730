package servers.rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import models.Student;

@Path("/students")
public class StudentRestService {
	
	@POST
	@Path("/post")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudent(Student stu) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("mv20220827_1");
			EntityManager em = emf.createEntityManager();
			EntityTransaction transaction = em.getTransaction();

			transaction.begin();
			em.persist(stu);
			transaction.commit();
		} catch(Exception ex) {
			System.out.println(ex);
		}
		
		String result = "Recorded : " + stu.toString();
		return Response.ok().entity(result).build();
	}
}
