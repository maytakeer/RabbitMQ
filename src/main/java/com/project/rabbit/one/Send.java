package com.project.rabbit.one;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * ������
 * @author Administrator
 *
 */
public class Send {
	//��������
	private final static String QUEUE_NAME = "queue";
	
	public static void main(String[] args) throws IOException {
		/**
		 * �������ӣ����ӵ�MabbitMQ
		 */
		ConnectionFactory factory = new ConnectionFactory();
		//����MabbitMQ��������ip����������
		factory.setHost("127.0.0.1");
		//����һ������
		Connection connection = factory.newConnection();
		//����һ��Ƶ��
		Channel channel = connection.createChannel();
		//ָ��һ������
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		//���͵���Ϣ
		String message = "hello world!";
		//�������з���һ����Ϣ
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		System.out.println("Send'" + message + "'");
		//�ر�Ƶ��������
		channel.close();
		connection.close();
	}
}
