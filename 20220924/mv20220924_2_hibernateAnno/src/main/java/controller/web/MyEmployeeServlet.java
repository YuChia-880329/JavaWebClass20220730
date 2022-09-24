package controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.MyEmployee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MyEmployeeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		MyEmployee e1 = new MyEmployee();
        e1.setId(1001);
        e1.setFirstName("Yui");
        e1.setLastName("Lee");

        MyEmployee e2 = new MyEmployee();
        e2.setId(1002);
        e2.setFirstName("Ming");
        e2.setLastName("Wang");

		
		Transaction transaction = session.beginTransaction();
		session.persist(e1);
		session.persist(e2);
		transaction.commit();
		session.close();
		resp.getWriter().append("save Employees");
	}
}
