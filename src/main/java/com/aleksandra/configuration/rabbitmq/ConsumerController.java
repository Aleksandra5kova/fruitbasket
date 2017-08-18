package com.aleksandra.configuration.rabbitmq;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

	@Autowired
	ConnectionFactory connectionFactory;

	@Autowired
	private NotificationLogger messageLogger;

	@Autowired
	private Receiver receiver;

	private Map<String, Consumer> consumerPool = new HashMap<String, Consumer>();

	@RequestMapping(path = "register/{consumerName}/{queueName}/{routingKey}", method = RequestMethod.POST)
	void register(@PathVariable String consumerName, @PathVariable String queueName, @PathVariable String routingKey) {
		// messageLogger.removeMessages();
		if (consumerPool.get(consumerName) == null) {
			consumerPool.put(consumerName, new Consumer(consumerName, routingKey, queueName + "-" + consumerName,
					connectionFactory, receiver));
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	List<String> messages() throws InterruptedException {
		Thread.sleep(3000);
 		List<String> messages = messageLogger.getLoggedMessages();
		messageLogger.removeMessages();
		return messages;
	}

	@RequestMapping(path = "/stop/{username}", method = RequestMethod.POST)
	void stopContainer(@PathVariable String username) {
		// proveri dali e admin
		consumerPool.get(username).getContainer().stop();
		consumerPool.remove(username);
	}

}
