package com.project.rabbit.two;

import java.io.IOException;

import org.apache.commons.lang.SerializationUtils;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

public class Receiver extends BaseConnector implements Runnable,Consumer{

	public Receiver(String queueName) throws IOException {
		super(queueName);
	}
	
	//实现Runnable的run方法
	public void run() {
		try {
			channel.basicConsume(queueName, true,this);
		} catch (IOException e) {
			
		}
		
	}
	
	
	/**
	 * 下面这些方法是实现Consumer接口的
	 */
	public void handleCancelOk(String consumerTag) {
		System.out.println("Consumer" + consumerTag + "registered");
	}

	

	public void handleDelivery(String consumerTag, Envelope env,
			BasicProperties props, byte[] body) throws IOException {
		MessageInfo messageInfo = (MessageInfo) SerializationUtils.deserialize(body);
		System.out.println("Message("+"channel:"+messageInfo.getChannel()+",content:"+messageInfo.getContent()+")received.");
	}
	
	public void handleCancel(String consumerTag) throws IOException {
		
	}
	
	public void handleConsumeOk(String consumerTag) {
		
	}

	public void handleRecoverOk(String consumerTag) {
		// TODO Auto-generated method stub
		
	}

	public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {
		// TODO Auto-generated method stub
		
	}

	

}
