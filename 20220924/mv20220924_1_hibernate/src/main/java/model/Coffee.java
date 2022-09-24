package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coffees")
public class Coffee {
	
	@Id
	@Column(name="COF_NAME")
	private String cofName;
	@Column(name="SUP_ID")
	private int supId;
	private double price;
	private int sales;
	private int total;
	
	
	
	public Coffee() {
	}
	public Coffee(String cofName, int supId, double price, int sales, int total) {
		this.cofName = cofName;
		this.supId = supId;
		this.price = price;
		this.sales = sales;
		this.total = total;
	}
	
	
	
	public String getCofName() {
		return cofName;
	}
	public void setCofName(String cofName) {
		this.cofName = cofName;
	}
	public int getSupId() {
		return supId;
	}
	public void setSupId(int supId) {
		this.supId = supId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	@Override
	public String toString() {
		return "Coffee [cofName=" + cofName + ", supId=" + supId + ", price=" + price + ", sales=" + sales + ", total="
				+ total + "]";
	}
	
	
}
