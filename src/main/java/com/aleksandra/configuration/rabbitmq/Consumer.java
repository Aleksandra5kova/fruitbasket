package com.aleksandra.configuration.rabbitmq;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

public class Consumer {

	private final ConnectionFactory connectionFactory;
	private String consumerName;
	private String routingKey;
	private String queueName;
	private SimpleMessageListenerContainer container; 

	public Consumer(String consumerName, String routingKey, String queueName, ConnectionFactory connectionFactory,
			Receiver receiver) {
		this.consumerName = consumerName;
		this.routingKey = routingKey;
		this.queueName = queueName;
		this.connectionFactory = connectionFactory;
		container = new SimpleMessageListenerContainer(connectionFactory);

		initContainer(receiver);
	}

	public String getRoutingKey() {
		return routingKey;
	}

	public String getQueueName() {
		return queueName;
	}

	public String getName() {
		return consumerName;
	}
	
	public SimpleMessageListenerContainer getContainer() {
		return container;
	}

	private void initContainer(Receiver receiver) {

		RabbitAdmin admin = new RabbitAdmin(connectionFactory);
		
		Queue queue = new Queue(queueName);
		admin.declareQueue(queue);
		
		FanoutExchange exchange = new FanoutExchange(GlobalConfig.DISTRIBUTION_EXCHANGE);
		admin.declareExchange(exchange);
		admin.declareBinding(BindingBuilder.bind(queue).to(exchange));

		MessageListenerAdapter adapter = new MessageListenerAdapter(receiver, "receiveMessage");
		container.setMessageListener(adapter);
		container.setQueueNames(queueName);
		container.start();
	}

}
