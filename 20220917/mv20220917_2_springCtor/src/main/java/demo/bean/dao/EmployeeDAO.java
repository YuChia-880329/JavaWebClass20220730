package demo.bean.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import demo.bean.model.Employee;

public class EmployeeDAO {
	private JdbcTemplate jdbcTemplate;
	
	public void setTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public int saveEmployee(Employee employee) {
		String str = "INSERT INTO employees "
				+ "(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle) "
				+ "VALUES (%d, '%s', '%s', '%s', '%s', '%s', '%d', '%s')";
		String query = String.format(str, employee.getEmployeeNumber(), 
				employee.getLastName(),
				employee.getFirstName(),
				employee.getExtension(),
				employee.getEmail(),
				employee.getOfficeCode(),
				employee.getReportsTo(),
				employee.getJobTitle());
		return jdbcTemplate.update(query);
	}
	
	public int updateEmployee(Employee employee) {
		String str = "UPDATE employees SET "
				+ "lastName='%s', firstName='%s', extension='%s', email='%s', officeCode='%s', reportsTo=%d, jobTitle='%s' WHERE employeeNumber=%d";
		String query = String.format(str, employee.getLastName(),
				employee.getFirstName(),
				employee.getExtension(),
				employee.getEmail(),
				employee.getOfficeCode(),
				employee.getReportsTo(),
				employee.getJobTitle());
		
		return jdbcTemplate.update(query);
	}
	
	public int deleteEmployee(Employee employee) {
		String str = "DELETE FROM employees WHERE emplyeeNumber=%d";
		String query = String.format(str, employee.getEmployeeNumber());
		return jdbcTemplate.update(query);
	}
}
