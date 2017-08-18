package com.aleksandra.configuration.rabbitmq;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class NotificationLogger {

	private List<String> loggedMessages = new ArrayList<String>();

	public List<String> getLoggedMessages() {
		return loggedMessages;
	}

	public void removeMessages() {
		loggedMessages = new ArrayList<>();
	}

	public void log(String notification) {
		loggedMessages.add(notification);
	}
}
