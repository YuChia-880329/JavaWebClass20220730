package demo.models;

public class User {
	private String name;
	private String password;
	private String address;
	private boolean receivePaper;
	private String[] favoriteFrameworks;
	
	
	public User() {
	}
	
	public User(String name, String password, String address, boolean receivePaper, String[] favoriteFrameworks) {
		this.name = name;
		this.password = password;
		this.address = address;
		this.receivePaper = receivePaper;
		this.favoriteFrameworks = favoriteFrameworks;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isReceivePaper() {
		return receivePaper;
	}
	public void setReceivePaper(boolean receivePaper) {
		this.receivePaper = receivePaper;
	}
	public String[] getFavoriteFrameworks() {
		return favoriteFrameworks;
	}
	public void setFavoriteFrameworks(String[] favoriteFrameworks) {
		this.favoriteFrameworks = favoriteFrameworks;
	}
	
	
}
