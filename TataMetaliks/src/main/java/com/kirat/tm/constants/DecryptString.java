package com.kirat.tm.constants;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Base64.Decoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DecryptString {
	
	public  static String main(String args) {
		
        try
        {
           /* String data = args ;
            String key = "1234567812345678";
            String iv = "1234567812345678";

            Decoder decoder = Base64.getDecoder();   
             byte[] encrypted1 = decoder.decode(data);

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            System.out.println(originalString.trim());
            return originalString.trim();*/
        	
			// Replace with your actual encrypted data (base64 encoded)
			String encodedData = args;
			// Replace with your actual secret key (must match the one used for encryption)
			String secretKey = "1234567812345678";

			byte[] encryptedData = Base64.getDecoder().decode(encodedData);
			byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);

			SecretKey secretKeyObj = new SecretKeySpec(keyBytes, "AES");
			Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

			// The IV used during encryption (must match the one used for encryption)
			byte[] iv = new byte[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

			GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);

			cipher.init(Cipher.DECRYPT_MODE, secretKeyObj, parameterSpec);

			byte[] decryptedData = cipher.doFinal(encryptedData);

			String originalString = new String(decryptedData, StandardCharsets.UTF_8);
//            System.out.println(originalString.trim());
			return originalString.trim();
        }
        catch (Exception e) {
            e.printStackTrace();
            return " ";
        }
//		return args;
    }

}
