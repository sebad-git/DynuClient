
package com.sdm.dynuclient.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author sebad-git
 */
public class Security {
    
    public static final String encriptSHA256(final String text){
         try {
             if(text==null || text.length()<1){ System.out.println("The text is empty"); return text; }
             final MessageDigest digest = MessageDigest.getInstance("SHA-256");
             final byte[] hash = digest.digest( text.getBytes(StandardCharsets.UTF_8));
             final StringBuilder hexString = new StringBuilder(2 * hash.length);
             for (int i = 0; i < hash.length; i++) {
                 String hex = Integer.toHexString(0xff & hash[i]);
                 if(hex.length() == 1) { hexString.append('0'); }
                 hexString.append(hex);
             }
             return hexString.toString();
        }
        catch (Exception e) { AppLogger.log(e); e.getMessage(); return text; }
    }
    
    
    private static final int PWD_ITERATIONS = 65536;
    private static final String KEY_ALGORITHM = "AES";
    private static final int KEY_SIZE = 128;
    private static final String ENCRYPT_ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String SECRET_KEY_FACTORY_ALGORITHM = "PBKDF2WithHmacSHA1";
    private static final Charset CHARSET = Charset.forName("UTF-8");
    
     public static String encriptAES(String password, String plainText) {
        try {
            final SecureRandom random = new SecureRandom();
            final byte saltBytes[] = new byte[20];
            random.nextBytes(saltBytes);
            final SecretKeyFactory skf = SecretKeyFactory.getInstance(SECRET_KEY_FACTORY_ALGORITHM);
            final PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), saltBytes, PWD_ITERATIONS, KEY_SIZE);
            final SecretKey secretKey = skf.generateSecret(spec);
            final SecretKeySpec key = new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
            //AES initialization
            final Cipher cipher = Cipher.getInstance(ENCRYPT_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //generate IV
            final byte[] ivBytes = cipher.getParameters().getParameterSpec(IvParameterSpec.class).getIV();
            final byte[] encryptedText = cipher.doFinal(plainText.getBytes(CHARSET));
            //se envía salt y vector al ppio del archivo, luego va el texto cifrado
            final byte[] result = new byte[saltBytes.length + ivBytes.length + encryptedText.length];
            System.arraycopy(saltBytes, 0, result, 0, saltBytes.length);
            System.arraycopy(ivBytes, 0, result, saltBytes.length, ivBytes.length);
            System.arraycopy(encryptedText, 0, result, saltBytes.length + ivBytes.length, encryptedText.length);
            return Base64.getEncoder().encodeToString(result);
        } catch (Exception e){ e.printStackTrace(); return plainText; }
    }

    public static String deciptAES(String password, String encryptedText) {
       try {
           final byte[] result = Base64.getDecoder().decode(encryptedText);
           //first 20 bytes = salt
           final byte[] saltBytes = new byte[20];
           System.arraycopy(result, 0, saltBytes, 0, 20);
           //segundos 16 bytes = iv
           final byte[] vector = new byte[16];
           System.arraycopy(result, 20, vector, 0, 16);
           final byte[] encryptTextBytes = new byte[result.length - 36];
           System.arraycopy(result, 36, encryptTextBytes, 0, result.length - 36);
           final SecretKeyFactory skf = SecretKeyFactory.getInstance(SECRET_KEY_FACTORY_ALGORITHM);
           final PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), saltBytes, PWD_ITERATIONS, KEY_SIZE);
           final SecretKey secretKey = skf.generateSecret(spec);
           final SecretKeySpec key = new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
           //decrypt the message
           final Cipher cipher = Cipher.getInstance(ENCRYPT_ALGORITHM);
           cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(vector));
           final byte[] decyrptTextBytes = cipher.doFinal(encryptTextBytes);
           return new String(decyrptTextBytes, CHARSET);
       } catch (Exception e){ e.printStackTrace(); return encryptedText; }
    }
}
