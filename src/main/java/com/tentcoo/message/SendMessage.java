package com.tentcoo.message;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tentcoo.entity.UserEntity;

@Component
public class SendMessage {
	
	@Resource
	RestTemplate restTemplate;
	
	@Resource
	WrapMessage wapMessage;
	
	private static String KINGDEE_ENDPOINT  = "http://msg.gcu.edu.cn/pubacc/pubsend";
	
	public String sendMessage(String message,UserEntity member) {
		MessageInfo messageBean = wapMessage.wrapMessage(message, member);
		return restTemplate.postForObject(KINGDEE_ENDPOINT, messageBean, String.class);
	}

}
