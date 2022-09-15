package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Product;

public class ProductDAO {
	
	
	public ArrayList<Product> getProductList(){
		String url = "jdbc:mysql://localhost:3306/classicmodels?serverTimezone=Asia/Taipei&useUnicode=true&characterEncoding=utf8&useSSL=false";
		String user = "root";
		String password = "1234";
		String query = "SELECT productCode as code, quantityInStock as quantity, productDescription as description, buyPrice as price FROM Products where buyPrice>=90.0";
	
		ArrayList<Product> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException ex) {
			System.out.println(ex);
		}
		
		try(Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);) {
			
			
			while(rs.next()) {
				Product pro = new Product();
				pro.setCode(rs.getString("code"));
				pro.setQuantity(rs.getInt("quantity"));
				pro.setDescription(rs.getString("description"));
				pro.setPrice(rs.getString("price"));
				list.add(pro);
			}
			
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
		return list;
	}
}
