package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	private int id;
	@Column(name="stu_name")
	private String stuName;
	private int age;
	
	
	public Student() {
	}
	public Student(int id, String stuName, int age) {
		this.id = id;
		this.stuName = stuName;
		this.age = age;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", stuName=" + stuName + ", age=" + age + "]";
	}
	
	
}