package com.darwinsys.springmvc;

import org.springframework.stereotype.Component;

@Component
public class SpringBean {

	public String getMessage() {
		return "Greetings in the name of Spring and JSF";
	}

}
