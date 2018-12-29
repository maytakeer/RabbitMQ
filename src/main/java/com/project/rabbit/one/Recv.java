package com.project.rabbit.one;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;

/**
 * 接受者
 * @author Administrator
 *
 */
public class Recv {
	//队列名称
	private final static String QUEUE_NAME = "queue";
	public static void main(String[] args) throws IOException,  ConsumerCancelledException, InterruptedException {
		//打开连接和创建频道，与发送端一样
		ConnectionFactory factory = new ConnectionFactory();
		//设置MabbitMQ所在主机ip或者主机名
		factory.setHost("127.0.0.1");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		//声明队列，主要为了防止消息接收者先运行此程序，队列还不存在时创建队列。
		channel.queueDeclare(QUEUE_NAME,false,false,false,null);
		System.out.println("Waiting for messages.To exit press CTRL+C");
		
		//创建队列消费者
		QueueingConsumer consumer = new QueueingConsumer(channel);
		//指定消费队列
		channel.basicConsume(QUEUE_NAME, true,consumer);
		while(true){
			//nextDelivery是一个阻塞方法（内部实现其实是阻塞队列的take方法）
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			System.out.println("Received'" + message + "'");
			
		}
	}
}
