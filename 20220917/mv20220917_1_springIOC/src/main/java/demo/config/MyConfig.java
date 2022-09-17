package demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import demo.bean.MyBean;

@Configuration
@ComponentScan(value = "demo.bean")
public class MyConfig {
	
	@Bean
	public MyBean getService() {
		MyBean myBean = new MyBean("Just Test");
		return myBean;
	}
}
