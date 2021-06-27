package com.foodbox.utils;

public class CommonUtil {

	
	private static final String alphabets = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
	
	public static String getUserName() {
		
		StringBuilder userName = new StringBuilder();
		
		for(int i=0; i<5; i++) {
			
			int randomIndex = (int) (Math.random() * alphabets.length());
		
			userName.append(alphabets.charAt(randomIndex));
			
			
		}
		
		userName.append("@user.com");
		
		return userName.toString();
		
	}
	
	
	public static long getPhoneNumber() {
	
		return 1234567899;
	
	}
}
