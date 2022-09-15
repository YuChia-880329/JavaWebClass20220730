package controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertCoffeeServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf8");
		try(PrintWriter out = resp.getWriter();){
			
			String coffee = req.getParameter("coffee");
			int supplier = Integer.parseInt(req.getParameter("supplier"));
			double price = Double.parseDouble(req.getParameter("price"));
			int sale = Integer.parseInt(req.getParameter("sale"));
			int total = Integer.parseInt(req.getParameter("total"));
			
			out.println("<html>");
			
			
			out.println("<head>");
			out.println("<title>Servlet InsertCoffee</title>");
			out.println("</head>");
			
			
			out.println("<body>");
			insertCoffee(coffee, supplier, price, sale, total);
			out.println("新增完成");
			out.println("</body>");
			
			
			out.println("</html>");
		}catch(ClassNotFoundException | SQLException ex) {
			System.out.println(ex);
		}
	}
	
	private void insertCoffee(String coffee, int supplier, double price, int sale, int total) throws ClassNotFoundException, SQLException {
		
		
		String url = "jdbc:mysql://localhost:3306/classicmodels?serverTimezone=Asia/Taipei&useUnicode=true&characterEncoding=utf8&useSSL=false";
		String user = "root";
		String password = "1234";
		String driver = "com.mysql.cj.jdbc.Driver";
		String query = "insert into COFFEES(COF_NAME, SUP_ID, PRICE, SALES, TOTAL) values (?, ?, ?, ?, ?)";
		
		Connection con = null;
		
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			try(PreparedStatement st = con.prepareStatement(query);){
				st.setString(1, coffee);
				st.setInt(2, supplier);
				st.setDouble(3, price);
				st.setInt(4, sale);
				st.setInt(5, total);
				st.executeUpdate();
			}
			con.commit();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			
			if(con != null) {
				try {
					System.err.println("Transaction is being rolled back");
					con.rollback();
				}catch(SQLException ex2) {
					ex2.printStackTrace();
					throw ex2;
				}
			}
			
			throw ex;
		}finally {
			if(con != null) {
				try {
					con.setAutoCommit(true);
					con.close();
				}catch(SQLException ex) {
					System.out.println(ex);
				}
			}
		}
	}
}
