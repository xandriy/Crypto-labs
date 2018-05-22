package ua.springboot.web.utils;

import java.util.ArrayList;
import java.util.List;

public class Lab2Utils {

	
	private static List<Integer> getKeyInList(int key){
		List<Integer> keyList = new ArrayList<>();
		while(key > 0) {
			keyList.add(key%10);
			key /=10;
		}
		return keyList;
	}
	
	public static String codeString(int key, String text,int loop) {
		
		
		StringBuilder newString = new StringBuilder();
		List<Integer> keyList = getKeyInList(key);
		int keyLength = keyList.size();
		for(int k = 0;k < loop;k++) {
			for(int i = 1;i <= keyLength;i++) {
				for(int j = 0;j <= text.length() - keyLength;j+=keyLength) {
					newString.append(text.charAt((keyLength - keyList.indexOf(i) - 1) + j));
				}
			}	
			if(k < loop - 1) {
				text = newString.toString();
				newString = new StringBuilder();
			}
		}
		return newString.toString();
	}
	
	public static String decodeString(int key, String text,int loop) {
		StringBuilder newString = new StringBuilder();
		List<Integer> keyList = getKeyInList(key);
		int keyLength = keyList.size();
		
		int numberOfRows = (int)text.length()/keyList.size();
		
		for(int k = 0;k < loop;k++) {
			for(int j = 0;j <= numberOfRows -1;j++) {
				for(int i = keyLength -1;i >= 0;i--) {
					newString.append(text.charAt((keyList.get(i)-1)*numberOfRows +j));
				}
			}
			if(k < loop - 1) {
				text = newString.toString();
				newString = new StringBuilder();
			}
		}
		return newString.toString();
	}
	
}
