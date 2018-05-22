package ua.springboot.web.utils;

import static org.mockito.Matchers.anyBoolean;

public class Lab3Utils {

	private static char[] alphabet = {'a','b','c','d','e','f','е','є','ж','з','и','і',
			'ї','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ь','ю','я'};
	
	
	public static int[] countFrequencyOfLitters(String text){
		int[] frequency = new int[alphabet.length];
		int numberOfLetters = 0;
		for(char c : text.toCharArray()) {
			
			for(int i = 0;i<alphabet.length;i++) {
				if(Character.toLowerCase(c) == alphabet[i]) {
					frequency[i]++;
					numberOfLetters++;
					break;
				}
			}

			
		}
		
		return frequency;
	}
	
	public static int getStep(int[] frequency) {
		int letterPosition = 0;
		int maxNumber = frequency[letterPosition];
		for(int i = 1;i < frequency.length;i++) {
			if(frequency[i] > maxNumber) {
				letterPosition = i;
				maxNumber = frequency[i];
			}
		}
		for(int i = 0;i<alphabet.length;i++) {
			if(alphabet[i] == 'о') {
				return Math.abs(i - letterPosition);
			}
		}
		return 0;
	}
}


