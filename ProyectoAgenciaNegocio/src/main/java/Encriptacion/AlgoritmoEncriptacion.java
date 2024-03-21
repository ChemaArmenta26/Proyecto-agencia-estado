/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Encriptacion;

import java.awt.RenderingHints.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author pc
 */
public class AlgoritmoEncriptacion {

    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "abcdefghijklmnopqrstuvwxyz123456";

    public  String encrypt(String value) throws Exception {
        SecretKeySpec key = generateKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, (java.security.Key) key);
        byte[] encryptedByteValue = cipher.doFinal(value.getBytes("utf-8"));
        return Base64.getEncoder().encodeToString(encryptedByteValue);
    }

    public  String decrypt(String value) throws Exception {
        SecretKeySpec key = generateKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, (java.security.Key) key);
        byte[] decryptedValue64 = Base64.getDecoder().decode(value);
        byte[] decryptedByteValue = cipher.doFinal(decryptedValue64);
        return new String(decryptedByteValue, "utf-8");
    }

    private static SecretKeySpec generateKey() {
        return new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
    }
   
    
}
