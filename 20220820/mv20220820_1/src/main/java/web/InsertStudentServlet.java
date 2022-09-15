package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Student;


public class InsertStudentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("mv20220820_1");
			EntityManager em = emf.createEntityManager();

			Student st1 = new Student();
			st1.setId(1001);
			st1.setStuName("Kevin");
			st1.setAge(25);

			Student st2 = new Student();
			st2.setId(1002);
			st2.setStuName("Sabrina");
			st2.setAge(21);

			EntityTransaction transaction = em.getTransaction();

			transaction.begin();
			em.persist(st1);
			em.persist(st2);
			transaction.commit();

			em.close();
			emf.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
//		PrintWriter out = resp.getWriter();
//		out.println("successfully insert");
		
		resp.sendRedirect("studentJPA");
	}
}
