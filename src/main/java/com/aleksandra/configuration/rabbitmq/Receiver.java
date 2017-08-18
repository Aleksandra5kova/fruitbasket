package com.aleksandra.configuration.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@Autowired
	private NotificationLogger messageLogger;

	public void receiveMessage(String message) throws Exception {
		messageLogger.log(message);
	}

}
