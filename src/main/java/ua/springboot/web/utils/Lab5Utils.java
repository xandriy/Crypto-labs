package ua.springboot.web.utils;

public class Lab5Utils {

	public static String code(String key, String text) {
		String[] keys = key.split(" ");
		if(text.length()%2 == 1)
			text += " ";
		char[] textChar = text.toCharArray();
		char[] newText = new char[textChar.length];
		for(int i = 0; i < textChar.length;i+=2) {
			int left = textChar[i];
			int right = textChar[i+1];
			
			
			for(int j = 0;j < keys.length;j++) {
				right = ((left * Integer.valueOf(keys[j]))% 16) ^right ;
			
				if(j != textChar.length - 1) {
					int temp = left;
					left = right;
					right = temp;
				}
				
			}
			newText[i] = (char)left;
			newText[i+1] = (char) right;
		}
		return String.valueOf(newText);
	}
		
	public static String decode(String key, String text) {
		
		String[] keys = key.split(" ");
		
		char[] textChar = text.toCharArray();
		char[] newText = new char[textChar.length];
		for(int i = 0; i < textChar.length;i+=2) {
			int left = textChar[i];
			int right = textChar[i+1];
			
			for(int j = keys.length - 1;j >= 0;j--) {
				right = ((left * Integer.valueOf(keys[j])) % 16)^right ;
				if(j != textChar.length - 1) {
					int temp = left;
					left = right;
					right = temp;
				}
			
			}
			newText[i] = (char)left;
			newText[i+1] = (char) right;
		}
		return String.valueOf(newText);
	}	
}
