package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.StudentDAO;
import models.Student;

@WebServlet("/json")
public class JsonSevlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf8");
		PrintWriter out = resp.getWriter();
		
		
		
		String jsonStr = req.getParameter("stuData");
		
		GsonBuilder builder = new GsonBuilder();
		//builder.setPrettyPrinting();
		Gson gson = builder.create();
		
		Student[] students = gson.fromJson(jsonStr, Student[].class);
		

		boolean result = StudentDAO.addStudent(students);
		
		
		if(result)
			out.println("success");
		else
			out.println("fail");

		
	}
}
