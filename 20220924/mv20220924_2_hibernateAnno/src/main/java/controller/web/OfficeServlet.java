package controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Office;

public class OfficeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Configuration config = new Configuration().configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		
		Office of = new Office();
		of.setOfficeCode("8");
		of.setCity("Taipei");
		of.setPhone("0123456789");
		of.setAddressLine1("X Road");
		of.setAddressLine2("NO.15");
		of.setState("TW");
		of.setCountry("Taiwan");
		of.setPostalCode("100");
		of.setTerritory("Asia");
		
		Transaction transaction = session.beginTransaction();
		session.persist(of);
		transaction.commit();
		session.close();
		resp.getWriter().append("Office Saved");
		
		
	}
}
