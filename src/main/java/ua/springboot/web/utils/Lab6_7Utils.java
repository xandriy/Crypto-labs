package ua.springboot.web.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Lab6_7Utils {
	private static char[] alphabet = {'а','б','в','г','ґ','д','е','є','ж','з','и','і',
			'ї','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ь','ю','я',
			',','.', ' ', '?'};
	
	public static String code(String key, String text) {
		
		if(text.length()%2 == 1)
			text += " ";
		
		
		int[][] matrix = new int[3][3];
		int[] textInteger = new int[text.length()];
		int[] textIntegerCode = new int[text.length()+text.length()/2];
		
		for(int i = 0;i < text.length();i++) {
			textInteger[i] = getLetterIndexInAlphabet(text.charAt(i));
			System.out.print(textInteger[i] + " ");
		}
		for(int i = 0,k = 0;i < 3;i++)
			for(int j = 0;j < 3;j++, k++)
				matrix[i][j] = getLetterIndexInAlphabet(key.charAt(k));
		
		for(int i = 0,k = 0; i < textInteger.length;i+=2, k+=3) {
			int vector[] = matrixMul(matrix, new int[]{
					textInteger[i],
					textInteger[i+1],
					getRandomLetter()});
			for(int j = 0;j < 3;j++)
				textIntegerCode[k + j] = vector[j];
		}
		
		return getLetterByIndex(textIntegerCode);
	}	
		
	public static String decode(String key, String text) {
		int[][] matrix = new int[3][3];
		int[] textInteger = new int[text.length()];
		int[] textIntegerCode = new int[text.length()*2/3];
		
		for(int i = 0;i < text.length();i++)
			textInteger[i] = getLetterIndexInAlphabet(text.charAt(i));
		
		for(int i = 0,k = 0;i < 3;i++)
			for(int j = 0;j < 3;j++, k++)
				matrix[i][j] = getLetterIndexInAlphabet(key.charAt(k));
		
		for(int i = 0,k = 0; i < textInteger.length;i+=3,k+=2) {
			int vector[] = matrixMul(inverseMatrix(matrixTranspont(matrix)), new int[]{
					textInteger[i],
					textInteger[i+1],
					textInteger[i+2]});
			for(int j = 0;j < 2;j++)
				textIntegerCode[k + j] = vector[j];
		}
		
		return getLetterByIndex(textIntegerCode);
	}
	
	public static Map<Character,Integer> getMap(int[] frequency){
		Map<Character, Integer> mapOfOpenKeyUnsort = new HashMap<>();
		for(int i = 0;i < frequency.length;i++) {
			if(alphabet[i] != ' ')
				mapOfOpenKeyUnsort.put(alphabet[i], frequency[i]);
			else
				mapOfOpenKeyUnsort.put('_', frequency[i]);
		}
		Map<Character, Integer> mapOfOpenKeySort = mapOfOpenKeyUnsort.entrySet().stream()
			    .sorted(Entry.<Character,Integer>comparingByValue().reversed())
			    .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
			                              (e1, e2) -> e1, LinkedHashMap::new));;
		return mapOfOpenKeySort;
	}
	
	public static int[] getCountOfEveryLeter(String text) {
		int[] frequency = new int[alphabet.length];
		for(char c : text.toCharArray()) {
			
			for(int i = 0;i<alphabet.length;i++) {
				if(Character.toLowerCase(c) == alphabet[i]) {
					frequency[i]++;
					break;
				}
			}			
		}
		return frequency;
		
	}
	
	private static int getRandomLetter() {
		return (int)Math.random()*alphabet.length;
	}

	private static int[][] inverseMatrix(int[][] matrix){
		int[][] inverseMatrix = new int[3][3];
		inverseMatrix[0][0] = matrix[1][1]*matrix[2][2] - matrix[1][2]*matrix[2][1];
		inverseMatrix[0][1] = -(matrix[1][0]*matrix[2][2] - matrix[1][2]*matrix[2][0]);
		inverseMatrix[0][2] = matrix[1][0]*matrix[2][1] - matrix[1][1]*matrix[2][0];
		
		inverseMatrix[1][0] = -(matrix[0][1]*matrix[2][2] - matrix[0][2]*matrix[2][1]);
		inverseMatrix[1][1] = matrix[0][0]*matrix[2][2] - matrix[0][2]*matrix[2][0];
		inverseMatrix[1][2] = -(matrix[0][0]*matrix[2][1] - matrix[0][1]*matrix[2][0]);
		
		inverseMatrix[2][0] = matrix[0][1]*matrix[1][2] - matrix[0][2]*matrix[1][1];
		inverseMatrix[2][1] = -(matrix[0][0]*matrix[1][2] - matrix[0][2]*matrix[1][0]);
		inverseMatrix[2][2] = matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
		
		int det = matrix[0][0]*matrix[1][1]*matrix[2][2] +
				  matrix[0][1]*matrix[1][2]*matrix[2][0] +
				  matrix[0][2]*matrix[1][0]*matrix[2][1] - 
				  matrix[0][2]*matrix[1][1]*matrix[2][0] -
				  matrix[0][0]*matrix[1][2]*matrix[2][1] -
				  matrix[0][1]*matrix[1][0]*matrix[2][2];
		det = det % 37;
		System.out.println("det - " + det);
		
		for(int i = 0;i < 3;i++)
			for(int j = 0;j < 3;j++) {
				inverseMatrix[i][j] = ((inverseMatrix[i][j] % 37)*3)%37;
				if(inverseMatrix[i][j] < 0)
					inverseMatrix[i][j] = inverseMatrix[i][j] + 37;
			}
		return inverseMatrix;
	}
	
	private static int[][] matrixTranspont(int[][] matrix) {
		int[][] transpontMatrix = new int[3][3];
		for(int i = 0;i < 3;i++) {
			for(int j = 0;j < 3;j++) {
				transpontMatrix[j][i] = matrix[i][j];
			}
		}
		return transpontMatrix;
	}
	
	private static int[] matrixMul(int[][] matrix, int[] vector) {
		int[] result = new int[3];
		
		for(int i = 0;i < 3; i++) {
			int sum = 0;
			for(int j = 0;j < 3;j++) {
				sum += matrix[i][j] * vector[j]; 
			}
			result[i] = sum % alphabet.length;
		}
		
		return result;
	}
	
	private static int getLetterIndexInAlphabet(char letter) {
		for(int i = 0;i < alphabet.length;i++) {
			if(letter == alphabet[i] || letter == Character.toUpperCase(alphabet[i]))
				return i;
		}
		return 35;
	}
	
	private static String getLetterByIndex(int[] index) {
		StringBuilder textString = new StringBuilder();
		for(int i = 0;i < index.length;i++) {
			textString.append(alphabet[index[i]]);
		}
		return textString.toString();
	}
	
	
}
