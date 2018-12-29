package com.project.rabbit.two;

import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		Receiver receiver = new Receiver("testQueue");
		Thread thread = new Thread(receiver);
		thread.start();
		Sender sender = new Sender("testQueue");
		for (int i = 0; i < 10; i++) {
			MessageInfo messageInfo = new MessageInfo();
			messageInfo.setChannel("test");
			messageInfo.setContent("msg"+i);
			sender.sendMessage(messageInfo);
		}
	}
}
