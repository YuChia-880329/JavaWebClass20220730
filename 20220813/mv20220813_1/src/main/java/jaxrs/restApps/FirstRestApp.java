package jaxrs.restApps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/app")
public class FirstRestApp extends Application{

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> set = new HashSet<>(Arrays.<Class>asList());
		return set;
	}
	
	
}
