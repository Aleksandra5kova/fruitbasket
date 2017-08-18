package not.used;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/*@Component*/
public class RabbitRunner {

	private final RabbitTemplate rabbitTemplate;
	private final RabbitReceiver receiver;

	public RabbitRunner(RabbitTemplate rabbitTemplate, RabbitReceiver receiver) {
		super();
		this.rabbitTemplate = rabbitTemplate;
		this.receiver = receiver;
	}

	public void send(String message) throws Exception {
		System.out.println("Sending message...");
		rabbitTemplate.convertAndSend(RabbitConfiguration.queueName, message);

	}

	public void receive() throws Exception {
		System.out.println("Receiving message...");
	}

}
