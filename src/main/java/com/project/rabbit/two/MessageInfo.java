package com.project.rabbit.two;

import java.io.Serializable;

/**
 * ���͵Ķ���
 * @author Administrator
 *
 */
public class MessageInfo implements Serializable{

	private static final long serialVersionUID = -5979223943159997678L;
	
	//����
	private String channel;
	
	//��Դ
	private String content;

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

}
