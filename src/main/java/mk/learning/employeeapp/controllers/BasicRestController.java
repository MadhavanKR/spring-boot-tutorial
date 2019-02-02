package mk.learning.employeeapp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mk.learning.employeeapp.model.Message;
import mk.learning.employeeapp.services.BasicService;

@RestController
public class BasicRestController {

	/*
	 * any objects that you place in method signature for a requestMapping method, spring tries to fill it for you
	 * Most useful objects are HttpServletRequest, ModelMap, @RequestParam, @PathVariable
	 * @PathVariable is usually used to classify web-resources. for example, localhost:8080/{username}/tweets
	 * @RequestParam is usually used to query web-resources. for example, localhost:8080/search?username=maddy
	 * 
	 * When you return a proper pojo object as return value for a rest controller method, Spring internally converts it into a json and returns
	 */
	
	@Autowired
	BasicService myService;
	
	@RequestMapping(value="helloRest", method=RequestMethod.GET)
	public Message helloRest(HttpServletRequest request) {
		//no scope for any business logic
		//at most you can trim data/ pre-process data and send to service
		//and pre-process output before passing on to view
		
		return myService.getMessagePojo(request.getParameter("from"));
	}
	
	@RequestMapping(value="/helloRest/{from}",method=RequestMethod.GET)
	public Message helloRestV2(@PathVariable String from) {
		return myService.getMessagePojo(from);
	}
	
}
