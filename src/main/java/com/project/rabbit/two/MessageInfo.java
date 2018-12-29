package com.project.rabbit.two;

import java.io.Serializable;

/**
 * 发送的对象
 * @author Administrator
 *
 */
public class MessageInfo implements Serializable{

	private static final long serialVersionUID = -5979223943159997678L;
	
	//渠道
	private String channel;
	
	//来源
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
