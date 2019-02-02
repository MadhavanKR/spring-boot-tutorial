package mk.learning.employeeapp.services;

import org.springframework.stereotype.Component;

import mk.learning.employeeapp.model.BasicModel;
import mk.learning.employeeapp.model.Message;

@Component //anything marked @Component, spring will create a bean for it automatically.
public class BasicService {

	public String getMessage1() {
		return BasicModel.message;
	}
	
	public Message getMessagePojo(String from) {
		Message msg = new Message();
		msg.setMessage(BasicModel.message);
		msg.setFrom(from);
		msg.setTo("maddy baby");
		return msg;
	}
	
}
