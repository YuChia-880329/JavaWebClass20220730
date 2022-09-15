package web;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Student;

public class ShowStudentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Student> studentList = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("mv20220820_1");
			EntityManager em = emf.createEntityManager();
			EntityTransaction transaction = em.getTransaction();

			transaction.begin();
			Query query = em.createQuery("SELECT s FROM Student s");
			studentList = query.getResultList();
			transaction.commit();

			em.close();
			emf.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		req.setAttribute("students", studentList);
		req.getRequestDispatcher("showJPA/student.jsp").forward(req, resp);
	}
}
