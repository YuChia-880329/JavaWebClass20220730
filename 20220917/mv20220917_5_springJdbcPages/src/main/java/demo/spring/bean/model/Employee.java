package demo.spring.bean.model;

public class Employee {
	private int employeeNumber;
	private String firstName;
	private String email;
	private String extension;
	private String jobTitle;
	
	
	public Employee() {
	}
	public Employee(int employeeNumber, String firstName, String email, String extension, String jobTitle) {
		this.employeeNumber = employeeNumber;
		this.firstName = firstName;
		this.email = email;
		this.extension = extension;
		this.jobTitle = jobTitle;
	}
	
	
	
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	
	@Override
	public String toString() {
		return "Employee [employeeNumber=" + employeeNumber + ", firstName=" + firstName + ", email=" + email
				+ ", extension=" + extension + ", jobTitle=" + jobTitle + "]";
	}
	
	
}
