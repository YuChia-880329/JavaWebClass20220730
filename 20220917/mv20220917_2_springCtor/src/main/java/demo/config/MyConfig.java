package demo.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import demo.bean.Book;

@Configuration
@ComponentScan("demo.bean")
public class MyConfig {
	
	@Bean
	public Book getService() {
		Book book = new Book(101, "C# .Net", Arrays.asList("store1", "store2"));
		return book;
	}
}
