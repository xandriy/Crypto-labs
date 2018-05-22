package ua.springboot.web.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Lab4Utils {
	
	private static String PROJECT_PATH = System.getProperty("user.dir");
	private static String SEPARATOR = System.getProperty("file.separator");
	private static String IMAGIES_PATH = PROJECT_PATH+ SEPARATOR + "src" + 
			SEPARATOR + "main" + SEPARATOR + "webapp" + SEPARATOR + "resources"
			+ SEPARATOR + "img";
	private static String IMAGE_IN = IMAGIES_PATH + SEPARATOR+ "simpsonIn.bmp";
	private static String IMAGE_OUT = IMAGIES_PATH + SEPARATOR+ "simpsonOut.bmp";
	
	final static byte HEADSIZE = 120;
	
	public static  int code(String text) throws IOException {
		
        FileInputStream in = null;
        FileOutputStream out = null;
        int textSize = 0;
        try {
            in = new FileInputStream(IMAGE_IN);
            out = new FileOutputStream(IMAGE_OUT);
            
            int c;
            byte clearBit1 = (byte) 0xFE; // 254; // 11111110

            for (int i = 1; i <= HEADSIZE; i++)
                out.write(in.read());

            byte[] message = text.getBytes();
            
            for(byte bt : message) {
            	for (int bit = 7; bit >= 0; bit--) {
                    c = in.read() & clearBit1;
                    c = (c | ((bt >> bit) & 1));
                    out.write(c);
                }
                textSize++;
            }
           
            System.out.println("key: "+textSize);
            for (int bit = 7; bit >= 0; bit--)
                out.write(in.read());
            while ((c = in.read()) != -1)
                out.write(c);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        finally{
            if (in != null)
                in.close();
            if (out != null)
                out.close();
        }
        return textSize;
	}

	public static String decode(int textSize) throws IOException {
     
        FileInputStream in = null;
        byte[] result = new byte[textSize];
        try {
            in = new FileInputStream(IMAGE_OUT);
          
            for (int i = 1; i <= HEADSIZE; i++)
                in.read();

           
            System.out.println(textSize);
            for (int i = 0; i < result.length; i++) {
                for (int bit = 0; bit <= 7; bit++) {
                    result[i] = (byte) ((result[i] << 1) | (in.read() & 1));
                }
            }     
        }finally{
            if (in != null)
                in.close();
        }
    

		
        return new String(result);
        
	}
	
}
