package demo.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class MyAnnotatedBean {
	private int empId = 1;

	public MyAnnotatedBean() {
	}
	public MyAnnotatedBean(int empId) {
		this.empId = empId;
	}
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	
	@Override
	public String toString() {
		return "MyAnnotatedBean [empId=" + empId + "]";
	}
	
}
