package com.kaipai.ck.helper;

import java.util.HashMap;
import java.util.Map;

import com.kaipai.utils.Md5Utils;


public class LoginHelper {
	
	public static Map<String, Object> ticketMap = new HashMap<String, Object>();
	public static Map<String, String> codeMap = new HashMap<String, String>(); 
	
	public static void main(String[] args) {
		System.out.println(Md5Utils.getMD5("cloud"));
	}
}
