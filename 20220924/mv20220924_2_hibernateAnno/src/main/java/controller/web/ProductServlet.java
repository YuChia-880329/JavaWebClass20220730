package controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import model.Product;

public class ProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		
		List<Product> list = session.createQuery("FROM Product").list();
		
		
		System.out.println(list.get(0));
		
		try(PrintWriter out = resp.getWriter();){
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Show Products</title>");
			out.println("</head>");
			out.println("<body>");
			Iterator<Product> it = list.iterator();
			while(it.hasNext()) {
				out.println(it.next() + "<br/>");
			}
			out.println("</body>");
			out.println("</html>");
		}
	}
}
