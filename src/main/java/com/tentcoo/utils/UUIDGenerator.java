package com.tentcoo.utils;

import java.net.InetAddress;

import org.springframework.stereotype.Component;

public class UUIDGenerator {
	
	private static String splitToken = "";
	private static final int IP;
	private static short counter = (short) 0;
	private static final int JVM = (int) ( System.currentTimeMillis() >>> 8 );
	
	static {
		int ipadd;
		try {
			ipadd = toInt( InetAddress.getLocalHost().getAddress() );
		}
		catch (Exception e) {
			ipadd = 0;
		}
		IP = ipadd;
	}
	
	/**
	 * 获取JVM启动时间
	 * @return
	 */
	protected int getJVM() {
		return JVM;
	}

	/**
	 * 为每个ID分配一个序列号<br>
	 * 在这里引入同步锁，将这个类作为临界资源，以保证ID的唯一性
	 * @return
	 */
	protected short getCount() {
		synchronized(UUIDGenerator.class) {
			if ( counter < 0 ) {
				counter=0;
			}
			return counter++;
		}
	}

	/**
	 * 获取本机的IP
	 * @return
	 */
	protected int getIP() {
		return IP;
	}
	
	/**
	 * 获取时间戳的高位
	 * @return
	 */
	protected short getHiTime() {
		return (short) ( System.currentTimeMillis() >>> 32 );
	}

	/**
	 * 获取时间戳
	 * @return
	 */
	protected int getTime() {
		return (int) System.currentTimeMillis();
	}
	
	/**
	 * 生成UUID
	 * @return
	 */
	public String generateUUID() {
		return format( getIP() ) + splitToken
				+ format( getJVM() ) + splitToken
				+ format( getHiTime() ) + splitToken
				+ format( getTime() ) + splitToken
				+ format( getCount() );
	}
	
	/**
	 * 把十进制转化为16进制
	 * @param intValue
	 * @return
	 */
	protected String format(int intValue) {
		String formatted = Integer.toHexString( intValue );
		StringBuilder buf = new StringBuilder( "00000000" );
		buf.replace( 8 - formatted.length(), 8, formatted );
		return buf.toString();
	}
	
	/**
	 * 把十进制转化为16进制
	 * @param shortValue
	 * @return
	 */
	protected String format(short shortValue) {
		String formatted = Integer.toHexString( shortValue );
		StringBuilder buf = new StringBuilder( "0000" );
		buf.replace( 4 - formatted.length(), 4, formatted );
		return buf.toString();
	}
	
	/**
	 * 把字节缓冲转换为10进制数字
	 * @param bytes
	 * @return
	 */
	public static int toInt(byte[] bytes) {
		int result = 0;
		for ( int i = 0; i < 4; i++ ) {
			result = ( result << 8 ) - Byte.MIN_VALUE + (int) bytes[i];
		}
		return result;
	}

}
