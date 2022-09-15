package model;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class HelloListener implements ServletContextListener{

	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext contx =  sce.getServletContext();
		contx.setAttribute("hello", HelloModel.helloModelInit());
	}
	
}
