package controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowSupServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "jdbc:mysql://localhost:3306/classicmodels?serverTimezone=Asia/Taipei&useUnicode=true&characterEncoding=utf8&useSSL=false";
		String user = "root";
		String password = "1234";
		String driver = "com.mysql.cj.jdbc.Driver";
		String query = "select SUP_ID, SUP_NAME, STREET, CITY, STATE, ZIP from SUPPLIERS";
	
		try {
			Class.forName(driver);
		}catch(ClassNotFoundException ex) {
			System.out.println(ex);
		}
		
		try(PrintWriter out = resp.getWriter();
				Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);) {
			
			
			out.println("<html>");
			
			out.println("<head>");
			out.println("<title>Servlet SelectSupplier</title>");
			out.println("</head>");
			
			out.println("<body>");
			viewTable(out, rs);
			out.println("</body>");
			
			out.println("</html>");
			
			
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}
	
	private void viewTable(PrintWriter out, ResultSet rs) throws SQLException {
		out.println("<table border='1'>");
		while(rs.next()) {
			out.println("<tr>");
			out.println("<td>");
			out.println(rs.getInt("SUP_ID"));
			out.println("</td>");
			out.println("<td>");
			out.println(rs.getString("SUP_NAME"));
			out.println("</td>");
			out.println("<td>");
			out.println(rs.getString("STREET"));
			out.println("</td>");
			out.println("<td>");
			out.println(rs.getString("CITY"));
			out.println("</td>");
			out.println("<td>");
			out.println(rs.getString("STATE"));
			out.println("</td>");
			out.println("<td>");
			out.println(rs.getString("ZIP"));
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}
}
