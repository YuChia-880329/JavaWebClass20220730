package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HelloModel;

@WebServlet(name= "HelloController", urlPatterns= {"/hello.do"})
public class HelloController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String user = req.getParameter("user");
		if(user==null || user.equals(""))
			user = "Janet";
		
		
		ServletContext contx = req.getServletContext();
		HelloModel hello = (HelloModel)contx.getAttribute("hello");
		
		String message = hello.sayHello(user);
		
		req.setAttribute("message", message);
		req.getRequestDispatcher("practice1/hello.jsp").forward(req, resp);
	}
}
