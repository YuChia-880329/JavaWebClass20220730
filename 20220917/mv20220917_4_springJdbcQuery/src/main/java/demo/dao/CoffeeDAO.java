package demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import demo.bean.model.Coffee;

public class CoffeeDAO {
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<Coffee> getAllCoffees(){
		return template.query("SELECT * FROM coffees", new RowMapper<Coffee>() {

			@Override
			public Coffee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Coffee coffee = new Coffee();
				coffee.setCofName(rs.getString("COF_NAME"));
				coffee.setSupId(rs.getInt("SUP_ID"));
				coffee.setPrice(rs.getDouble("PRICE"));
				coffee.setSales(rs.getInt("SALES"));
				coffee.setTotal(rs.getInt("TOTAL"));
				return coffee;
			}
		});
	}
}
