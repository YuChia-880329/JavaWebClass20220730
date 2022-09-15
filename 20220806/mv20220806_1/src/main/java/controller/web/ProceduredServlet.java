package controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProceduredServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "jdbc:mysql://localhost:3306/classicmodels?serverTimezone=Asia/Taipei&useUnicode=true&characterEncoding=utf8&useSSL=false";
		String user = "root";
		String password = "1234";
		String driver = "com.mysql.cj.jdbc.Driver";
		String query = "CALL GetEmployeeByCity(?)";
		
		
		String city = req.getParameter("city");
		
		if(city==null)
			city = "";
		
		try(PrintWriter out = resp.getWriter();) {
			
			Class.forName(driver);
			try(Connection con = DriverManager.getConnection(url, user, password);
					CallableStatement cs = con.prepareCall(query);){
				
				cs.setString(1, city);
				try(ResultSet rs = cs.executeQuery();){
					
					out.println("<html>");
					
					out.println("<head>");
					out.println("<title>Stored Procedured</title>");
					out.println("</head>");
					
					out.println("<body>");
					print(out, rs);
					out.println("</body>");
					
					out.println("</html>");
					
				}
			}
		}catch(ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	private void print(PrintWriter out, ResultSet rs) throws SQLException{
		
		boolean b = rs.next();
		if (b) {
			out.println("<table border='1'>");

			do {
				out.println("<tr>");
				out.println("<td>");
				out.println(rs.getString("employeeNumber"));
				out.println("</td>");

				out.println("<td>");
				out.println(rs.getString("firstname"));
				out.println("</td>");

				out.println("<td>");
				out.println(rs.getString("lastname"));
				out.println("</td>");

				out.println("<td>");
				out.println(rs.getString("email"));
				out.println("</td>");
				out.println("</tr>");
			} while (rs.next());
			
			out.println("</table>");
		}
	}
}
