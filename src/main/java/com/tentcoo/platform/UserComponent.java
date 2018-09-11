package com.tentcoo.platform;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class UserComponent {
	
	@Resource
	TokenManager tokenManager;
	
	@Resource
	RestTemplate restTemplate;
	
	ObjectMapper objectMapper;
	
	private Logger logger = Logger.getLogger(UserComponent.class);
	
	public UserComponent(){
		this.objectMapper = new ObjectMapper();
	}
	
	public Map<String, String> getUserInfo(String ticket) {
		String token = tokenManager.getAccessToken();
		String endpoint = "http://msg.gcu.edu.cn/openauth2/api/getcontext?ticket={ticket}&access_token={token}";
		try {
			String result = restTemplate.getForObject(endpoint, String.class, ticket,token);
			Map<String, String> res = objectMapper.readValue(result,HashMap.class);
			return res;
		} catch (Exception e) {
			logger.error("Catch exception",e);
		}
		return null;
	}

}
