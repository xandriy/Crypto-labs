package ua.springboot.web.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Lab8Utils {
	
	private static String PROJECT_PATH = System.getProperty("user.dir");
	private static String SEPARATOR = System.getProperty("file.separator");
	private static String FILE_PATH = PROJECT_PATH + SEPARATOR + "src" + 
			SEPARATOR + "main" + SEPARATOR + "webapp" + SEPARATOR + "resources"
			+ SEPARATOR + "text";
	private static String FILE_IN = FILE_PATH + SEPARATOR+ "crypted.txt";
	private static String FILE_OUT = FILE_PATH + SEPARATOR+ "encrypted.txt";
	
	
	public static byte[] code(String userKey, String initVector) throws NoSuchAlgorithmException, 
													NoSuchPaddingException, InvalidKeyException, 
													InvalidAlgorithmParameterException, 
													IllegalBlockSizeException, BadPaddingException {
		byte[] iv = initVector.getBytes();
		IvParameterSpec ivspec = new IvParameterSpec(iv);
		SecretKeySpec key;
		File file = new File(FILE_IN);
		
		System.out.println(file.getAbsolutePath());
		
		byte[] encrypted;
        StringBuilder builder = new StringBuilder();
        
        try {
            FileReader reader = new FileReader(file.getAbsolutePath());
            int c;
            while ((c = reader.read()) != -1) {
                builder.append((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        key = new SecretKeySpec(userKey.getBytes(), "AES"); 
        cipher.init(Cipher.ENCRYPT_MODE, key, ivspec);
        encrypted = cipher.doFinal(builder.toString().getBytes());
        
        try {
            FileWriter writer = new FileWriter(FILE_OUT);
            for (byte b : encrypted) {
                writer.write(String.valueOf(b));
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encrypted;
	}

	public static void decode(String userKey, String initVector,byte[] encrypted) throws NoSuchAlgorithmException, NoSuchPaddingException, 
											InvalidKeyException, InvalidAlgorithmParameterException,
	IllegalBlockSizeException, BadPaddingException {
		
		byte[] iv = initVector.getBytes();
		IvParameterSpec ivspec = new IvParameterSpec(iv);
		SecretKeySpec key;
		File file = new File(FILE_OUT);
		StringBuilder builder = new StringBuilder();
		 try {
	            FileReader reader = new FileReader(file.getAbsolutePath());
	            int c;
	            while ((c = reader.read()) != -1) {
	                builder.append((char) c);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		//byte[] encrypted = Base64.decodeBase64(builder.toString());
		
		Cipher decryrptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        key = new SecretKeySpec(userKey.getBytes(), "AES"); 
        decryrptCipher.init(Cipher.DECRYPT_MODE, key, ivspec);
        byte[] decrypted = decryrptCipher.doFinal(encrypted);
        try {
            FileWriter writer = new FileWriter(FILE_IN);
            for (byte b : decrypted) {
                writer.write((char) b);
            }
            writer.flush();
            writer.close();
           System.out.println(new String(decrypted,"UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	
}
