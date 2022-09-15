package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Coffee;
import models.Supplier;


public class InsertServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Supplier sup = null;
		
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("mv20220820_2");
			EntityManager em = emf.createEntityManager();
			EntityTransaction transaction = em.getTransaction();

			sup = new Supplier();
			sup.setSupId(1);
			sup.setSupName("Gjun");
			sup.setStreet("Kung Yuan Road");
			sup.setCity("Taipei");
			sup.setState("TW");
			sup.setZip("101");

			Coffee cof1 = new Coffee();
			cof1.setCofName("Flavor A");
			cof1.setPrice(new BigDecimal(200.0));
			cof1.setSales(10);
			cof1.setTotal(5);
			cof1.setSupplier(sup);

			Coffee cof2 = new Coffee();
			cof2.setCofName("Flavor B");
			cof2.setPrice(new BigDecimal(200.0));
			cof2.setSales(10);
			cof2.setTotal(5);
			cof2.setSupplier(sup);

			List<Coffee> cofList = new ArrayList<>();
			cofList.add(cof1);
			cofList.add(cof2);
			sup.setCoffees(cofList);

			transaction.begin();

			em.persist(sup);

			transaction.commit();
			em.close();
			emf.close();
			
			PrintWriter out = resp.getWriter();
			out.println("ok");
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}


}
