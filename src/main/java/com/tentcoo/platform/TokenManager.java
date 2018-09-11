package com.tentcoo.platform;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TokenManager {

	private String endPoint;
	private String accessToken;
	private Date expireTime;

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource
	RestTemplate restTemplate;

	public TokenManager() {
		// 下面填入AppID和AppSecret
		String secret = "";
		String id = "";
		this.endPoint = "http://msg.gcu.edu.cn/openauth2/api/token?grant_type=client_credential&appid=" + id + "&secret=" + secret;
	}
	
	@SuppressWarnings("unchecked")
	private void connectEndpoint() {
		Map<String, Object> res = (Map<String, Object>) restTemplate.getForObject(endPoint, HashMap.class);
		Integer expires = (Integer) res.get("expires_in");
		accessToken = (String) res.get("access_token");
		expireTime = new Date(System.currentTimeMillis() + expires * 1000);
	}

	public String getAccessToken() {
		Date current = new Date();
		if (accessToken == null) {
			this.connectEndpoint();
		} else if (current.after(expireTime)) {
			this.connectEndpoint();
		}
		return accessToken;
	}
}
