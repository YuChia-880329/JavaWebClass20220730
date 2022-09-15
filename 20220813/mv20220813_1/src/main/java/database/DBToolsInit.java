package database;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DBToolsInit implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext cxt = sce.getServletContext();
		
		DBTools dbTools = DBTools.DBTOOLS;
		String mySqlDriverStr = cxt.getInitParameter("mySqlDriver");
		String dbUrl = cxt.getInitParameter("dbUrl");
		String dbAcc = cxt.getInitParameter("dbAcc");
		String dbPwd = cxt.getInitParameter("dbPwd");
		dbTools.initDBTools(mySqlDriverStr, dbUrl, dbAcc, dbPwd);
	}
	
	
}
