package demo.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import demo.spring.bean.model.Employee;

public class EmployeeDAO {
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Employee> getEmployees(int rowId, int total){
		String queryStr = String.format("SELECT * FROM employees LIMIT %d, %d", rowId, total) ;
		
		RowMapper<Employee> rowMapper = new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setEmployeeNumber(rs.getInt("employeeNumber"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setExtension(rs.getString("extension"));
				employee.setEmail(rs.getString("email"));
				employee.setJobTitle(rs.getString("jobTitle"));
				return employee;
			}
		};
		
		return jdbcTemplate.query(queryStr, rowMapper);
	}
}
