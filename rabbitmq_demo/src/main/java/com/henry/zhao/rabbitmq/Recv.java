package com.henry.zhao.rabbitmq;

import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class Recv {
	private final static String QUEUE_NAME = "APIqueue";

	public static void main(String[] argv)
	      throws java.io.IOException,
	             java.lang.InterruptedException, TimeoutException {

	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("192.168.217.100");
		factory.setUsername("mq");
		factory.setPassword("mq");
		factory.setPort(5672);
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();

	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
	    
	    QueueingConsumer consumer = new QueueingConsumer(channel);
	    channel.basicConsume(QUEUE_NAME, true, consumer);

	    while (true) {
	      QueueingConsumer.Delivery delivery = consumer.nextDelivery();
	      String message = new String(delivery.getBody());
	      System.out.println(" [x] Received '" + message + "'");
	    }
	}
}
