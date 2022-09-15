package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DBTools;
import models.Student;

public class StudentDAO {
	
	
	public static boolean addStudent(Student[] students) {
		String queryStr = "INSERT INTO classicmodels.student(stu_name, age) "
				+ "VALUES(?, ?)";
		
		
		
		try(Connection con = DBTools.DBTOOLS.getConnection();
				PreparedStatement pst = con.prepareStatement(queryStr)){
			for(Student student : students) {
				pst.setString(1, student.getName());
				pst.setInt(2, student.getAge());
				int column = pst.executeUpdate();
				if(column <= 0)
					return false;
			}
			
			return true;
		}catch(SQLException ex) {
			System.out.println(ex);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return false;
	}

}
