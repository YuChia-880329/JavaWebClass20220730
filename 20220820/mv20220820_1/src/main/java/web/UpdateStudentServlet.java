package web;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Student;

public class UpdateStudentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("mv20220820_1");
			EntityManager em = emf.createEntityManager();
			EntityTransaction transaction = em.getTransaction();

//		Student stu = new Student();

			transaction.begin();

			Student stu = em.find(Student.class, 1002);
			stu.setId(1002);
			stu.setStuName("Ben");
			stu.setAge(23);

			em.merge(stu);

			transaction.commit();
			em.close();
			emf.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		resp.sendRedirect("studentJPA");
	}
}
