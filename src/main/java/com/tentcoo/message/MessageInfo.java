package com.tentcoo.message;

import java.util.List;

public class MessageInfo {

	private FromInfo from;
	private List<ToInfo> to;
	private int type;
	private Object msg;

	public FromInfo getFrom() {
		return from;
	}

	public void setFrom(FromInfo from) {
		this.from = from;
	}

	public List<ToInfo> getTo() {
		return to;
	}

	public void setTo(List<ToInfo> to) {
		this.to = to;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Object getMsg() {
		return msg;
	}

	public void setMsg(Object msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "MessageInfo [from=" + from + ", to=" + to + ", type=" + type + ", msg=" + msg + "]";
	}

}
