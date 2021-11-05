package com.example.util;

import org.springframework.stereotype.Component;

@Component
public class Util {

	public static String generateId() {
		StringBuffer sb = new StringBuffer();
		while (sb.length() < 10) {
			sb.append(Integer.toHexString(Constant.RANDOM.nextInt()));
		}
		return sb.toString().substring(0, 10);
	}
}
