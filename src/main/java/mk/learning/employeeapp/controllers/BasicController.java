package mk.learning.employeeapp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BasicController {
	
	/*
	 * @Controller is used for MVC (with views).
	 * @RestController is used for rest api development (does not support views. i.e html or jsp)
	 * all the htmls, css and js can be kept under src/main/resources/static and they can be referred using relative path to static folder
	 */
	
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String helloworld(ModelMap model,HttpServletRequest request) {
		return "tmp/hello.html"; //whatever string you return, spring by default searches for a view by that name
	}
	
}
