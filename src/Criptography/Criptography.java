package Criptography;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.*;
import javax.xml.bind.DatatypeConverter;

public class Criptography {

    public static String decryptCaesarCipher (String message, int key) {
        
        StringBuilder result = new StringBuilder();
        
        int n = message.length();

        for (int i = 0; i < n; i++) {
            
            int ascii = ((int) message.charAt(i)) - (key - 1);
                
            while (ascii < 32)
                ascii += 94;
        
            result.append((char)ascii);
            
        }

        return result.toString();
        
    }
    
    public static String SHA1(String input) throws NoSuchAlgorithmException {
        
        String sha1 = null;
        
        try {

            MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
            msdDigest.update(input.getBytes("UTF-8"), 0, input.length());
            sha1 = DatatypeConverter.printHexBinary(msdDigest.digest());

        } 

        catch (UnsupportedEncodingException e) {
            Logger.getLogger(Criptography.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return sha1;
    }
    
    public static String SHA256 (String data) throws NoSuchAlgorithmException {
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(data.getBytes());
        return bytesToHex(md.digest());
    
    }
    
    public static String bytesToHex (byte[] bytes) {
        
        StringBuffer result = new StringBuffer();
        for (byte byt : bytes) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    
    }
    
    public static String MD5 (String message) {

        String digest = null;
	
        try {
	
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes("UTF-8"));
		
            StringBuilder sb = new StringBuilder(2 * hash.length);
			
            for (byte b : hash)
                sb.append(String.format("%02x", b & 0xff));
			
                        
            digest = sb.toString();
	} 
        
        catch (Exception ex) {
	
            System.err.println(ex.getMessage());
	
        }
	
        return digest;
            
    }

}