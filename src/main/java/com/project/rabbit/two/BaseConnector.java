package com.project.rabbit.two;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class BaseConnector {
	protected Channel channel;
	protected Connection connection;
	protected String queueName;
	public BaseConnector(String queueName) throws IOException{
		this.queueName = queueName;
		//�����Ӻʹ���Ƶ��
		ConnectionFactory factory = new ConnectionFactory();
		//����MabbitMQ��������ip����������  127.0.0.1��localhost
		factory.setHost("127.0.0.1");
		//��������
		connection = factory.newConnection();
		//����Ƶ��
		channel = connection.createChannel();
		//������������
		channel.queueDeclare(queueName,false,false,false,null);
	}
}
