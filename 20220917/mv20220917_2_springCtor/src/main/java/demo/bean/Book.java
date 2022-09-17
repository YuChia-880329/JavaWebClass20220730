package demo.bean;

import java.util.List;

public class Book {
	private int id;
	private String name;
	private List<String> bookStores;
	
	
	public Book() {
	}
	public Book(int id, String name, List<String> bookStores) {
		this.id = id;
		this.name = name;
		this.bookStores = bookStores;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getBookStores() {
		return bookStores;
	}
	public void setBookStores(List<String> bookStores) {
		this.bookStores = bookStores;
	}
	
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", bookStores=" + bookStores + "]";
	}
	
	
}
