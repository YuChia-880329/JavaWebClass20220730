package controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Coffee;
import model.Supplier;

public class SupplierServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Query<Supplier> query = session.createQuery("FROM Supplier");
		List<Supplier> list = query.list();
		
		System.out.println(list.get(0));
		
		try(PrintWriter out = resp.getWriter();){
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Show Suppliers</title>");
			out.println("</head>");
			out.println("<body>");
			Iterator<Supplier> it = list.iterator();
			while(it.hasNext()) {
				out.println(it.next() + "<br/>");
			}
			out.println("</body>");
			out.println("</html>");
		}
	}
}
