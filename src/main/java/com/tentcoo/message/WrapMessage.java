package com.tentcoo.message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.tentcoo.entity.UserEntity;

@Component
public class WrapMessage {

	private static final String KINGDEE_NO = "";
	private static final String KINGDEE_ACCOUNT_NO = "";
	private static final String KINGDEE_ACCOUNT_SECRET = "";

	public MessageInfo wrapMessage(String message, UserEntity member) {
		String userId = member.getKingdeeId();
		String timestamp = Long.toString(System.currentTimeMillis());
		String nonce = Long.toHexString(System.currentTimeMillis());
		String[] encryptArray = { KINGDEE_NO, KINGDEE_ACCOUNT_NO, KINGDEE_ACCOUNT_SECRET, nonce, timestamp };
		FromInfo from = new FromInfo();
		from.setNo(KINGDEE_NO);
		from.setPub(KINGDEE_ACCOUNT_NO);
		from.setTime(timestamp);
		from.setNonce(nonce);
		from.setPubtoken(encrypt(encryptArray));
		List<ToInfo> toList = new ArrayList<ToInfo>();
		ToInfo to = new ToInfo();
		to.setNo(KINGDEE_NO);
		to.getUser().add(userId);
		toList.add(to);
		HashMap<String,Object> messageMap = new HashMap<String,Object>();
		messageMap.put("text", message);
		MessageInfo msg = new MessageInfo();
		msg.setFrom(from);
		msg.setMsg(messageMap);
		msg.setTo(toList);
		msg.setType(5);
		return msg;
	}

	public static String encrypt(String[] data) {
		Arrays.sort(data);
		return DigestUtils.shaHex(StringUtils.join(data));
	}

}
