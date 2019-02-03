package mk.learning.employeeapp.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import mk.learning.employeeapp.model.BasicModel;
import mk.learning.employeeapp.model.Message;

//@Component //anything marked @Component, spring will create a bean for it automatically.
public class BasicService {
	
	//@Value will search for a key mentioned in its parameters among the key-value pairs in application.properties
	//if found, the value will be assigned to corresponding variable.
	//if not found : then, if no default is given, it will throw an exception and application won't start. if default is given, then default value will be assigned
	@Value("${spring.application.name}")
	String applicationName;
	
	@PostConstruct
	public void init() {
		System.out.println("after bean creation, this method is executed");
	}
	
	public String getMessage1() {
		return BasicModel.message;
	}
	
	public Message getMessagePojo(String from) {
		Message msg = new Message();
		msg.setMessage(BasicModel.message);
		msg.setFrom(from);
		msg.setTo("maddy baby");
		msg.setApplicationName(applicationName);
		return msg;
	}
	
}
