package ua.springboot.web.utils;

public class Lab1Utils {

	private static char[] alphabet = {'а','б','в','г','ґ','д','е','є','ж','з','и','і',
			'ї','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ь','ю','я'};
	
	public static String codeString(int step, String text) {
		StringBuilder newString = new StringBuilder();
		for(int i = 0;i < text.length();i++) {
			for(int j = 0;j < alphabet.length; j++) {
				if(text.charAt(i) == alphabet[j]) {
					newString.append(alphabet[(j + step)%alphabet.length]);
					break;
				}
				if(j == alphabet.length - 1) {
					newString.append(text.charAt(i));
				}
			}
		}
		return newString.toString();
	}
	
	public static String decodeString(int step, String text) {
		StringBuilder newString = new StringBuilder();
		for(int i = 0;i < text.length();i++) {
			for(int j = 0;j < alphabet.length;j++) {
				if(text.charAt(i) == alphabet[j]) {
					int res = j - step;
					if(res >= 0) {
						newString.append((alphabet[(j - step)%alphabet.length]));
					}else {
						newString.append(alphabet[alphabet.length - (Math.abs(j - step))]);
					}
					
					break;
				}
				if(j == alphabet.length - 1) {
					newString.append(text.charAt(i));
				}
			}
		}
		return newString.toString();
	}
}
