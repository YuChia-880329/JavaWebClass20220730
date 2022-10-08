package model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Product;

public class ProductDAO {
	private List<Product> productList;
	
	public ProductDAO() {
//		productList = new ArrayList<>();
//		productList.add(new Product("po1", "JBud Elite", "images/p1.jpg", 20));
//		productList.add(new Product("p02", "EdiMax Wifi", "images/p2.jpg", 21));
//		productList.add(new Product("p03", "Asus Laptop", "images/p3.jpg", 22));
		
		fromDatabase();
	}
	
	private void fromDatabase() {
		Configuration config = new Configuration();
//		config.addAnnotatedClass(model.Product.class);
		config.configure("hibernate.cfg.xml");
		Session session = config.buildSessionFactory().openSession();
		
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			productList = session.createQuery("FROM Product").list();
			System.out.println("products : " + productList);
			transaction.commit();
		}catch(HibernateException ex) {
			if(transaction != null)
				transaction.rollback();
			ex.printStackTrace();
		}finally {
			if(session != null)
				session.close();
		}
	}
	
	public List<Product> findAll(){
		return productList;
	}
	
	public Product find(String id) {
		for(Product pro : productList) {
			if(pro.getId().equalsIgnoreCase(id))
				return pro;
		}
		return null;
	}
}
