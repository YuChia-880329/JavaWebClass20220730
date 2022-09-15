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

public class DeleteStudentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("mv20220820_1");
			EntityManager em = emf.createEntityManager();
			EntityTransaction transaction = em.getTransaction();

//			Student stu = new Student();
//			stu.setId(1001);
//			stu.setStuName("Kevin");
//			stu.setAge(24);

			transaction.begin();

//			stu = em.merge(stu);
			Student stu = em.find(Student.class, 1001);
			em.remove(stu);

			transaction.commit();
			em.close();
			emf.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		resp.sendRedirect("studentJPA");
	}
}
