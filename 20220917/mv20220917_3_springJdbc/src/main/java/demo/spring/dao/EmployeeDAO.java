package demo.spring.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import demo.spring.bean.model.Employee;

public class EmployeeDAO {
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int saveEmployee(Employee emp) {
		String str = "INSERT INTO employees (employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle) VALUES ("
				+ "%d, \'%s\', \'%s\', \'%s\', \'%s\', \'%s\', %d, \'%s\')";
		String query = String.format(str,
				emp.getEmployeeNumber(),
				emp.getLastName(),
				emp.getFirstName(),
				emp.getExtension(),
				emp.getEmail(),
				emp.getOfficeCode(),
				emp.getReportsTo(),
				emp.getJobTitle());
		return template.update(query);
	}
	
	public int updateEmployee(Employee emp) {
		String str = "UPDATE employees SET "
				+ "lastName=\'%s\', firstName=\'%s\', extension=\'%s\', email=\'%s\', officeCode=\'%s\', reportsTo=%d, jobTitle=\'%s\' "
				+ "WHERE employeeNumber=%d";
		String query = String.format(str, 
				emp.getLastName(),
				emp.getFirstName(),
				emp.getExtension(),
				emp.getEmail(),
				emp.getOfficeCode(),
				emp.getReportsTo(),
				emp.getJobTitle(),
				emp.getEmployeeNumber());
		return template.update(query);
	}
	
	public int deleteEmployee(Employee emp) {
		String str = "DELETE FROM employees WHERE employeeNumber=%d";
		String query = String.format(str, emp.getEmployeeNumber());
		return template.update(query);
	}
}
