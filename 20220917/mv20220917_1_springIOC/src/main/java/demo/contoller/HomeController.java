package demo.contoller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.bean.MyAnnotatedBean;
import demo.bean.MyBean;
import demo.config.MyConfig;

@Controller
@Scope("request")
public class HomeController {
	
	private MyBean myBean;
	private MyAnnotatedBean myAnnotatedBean;
	
	@Autowired
	public void setMyBean(MyBean myBean) {
		this.myBean = myBean;
	}
	@Autowired
	public void setMyAnnotatedBean(MyAnnotatedBean myAnnotatedBean) {
		this.myAnnotatedBean = myAnnotatedBean;
	}
	
	@RequestMapping(value="home", method=RequestMethod.GET)
	public String getService(Locale locale, Model model) {
		System.out.println("myBean : " + myBean.toString());
		System.out.println("myAnnotatedBean" + myAnnotatedBean.toString());
		
		Date date = new Date();
		DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = formatter.format(date);
		model.addAttribute("serverTime", formattedDate);
		
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
		MyBean service = ctx.getBean(MyBean.class);
		MyBean newService = ctx.getBean(MyBean.class);
		System.out.println("service : " + service);
		System.out.println("newService : " + newService);
		
		ctx.close();
		
		
		return "home";
	}
}
