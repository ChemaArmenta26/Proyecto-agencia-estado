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
 * Clase que implementa la lógica de negocio para encriptacion y Desencriptacion
 */
public class AlgoritmoEncriptacion {

    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "abcdefghijklmnopqrstuvwxyz123456";

    
    
    /**
     * Constructor por defecto de la clase AlgoritmoEncriptacion.
     */
    public AlgoritmoEncriptacion() {
    }
    
    
    
    

    /**
     * Encripta una cadena de texto utilizando el algoritmo AES.
     * @param value La cadena de texto a encriptar.
     * @return La cadena de texto encriptada.
     * @throws Exception Si ocurre algún error durante la encriptación.
     */
    public  String encrypt(String value) throws Exception {
        SecretKeySpec key = generateKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, (java.security.Key) key);
        byte[] encryptedByteValue = cipher.doFinal(value.getBytes("utf-8"));
        return Base64.getEncoder().encodeToString(encryptedByteValue);
    }

    /**
     * Desencripta una cadena de texto encriptada utilizando el algoritmo AES.
     * @param value La cadena de texto encriptada.
     * @return La cadena de texto desencriptada.
     * @throws Exception Si ocurre algún error durante la desencriptación.
     */
    public  String decrypt(String value) throws Exception {
        SecretKeySpec key = generateKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, (java.security.Key) key);
        byte[] decryptedValue64 = Base64.getDecoder().decode(value);
        byte[] decryptedByteValue = cipher.doFinal(decryptedValue64);
        return new String(decryptedByteValue, "utf-8");
    }

    
    /**
     * Genera una clave secreta basada en la clave secreta predefinida y el algoritmo AES.
     *
     * @return La clave secreta generada.
     */
    private static SecretKeySpec generateKey() {
        return new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
    }
   
    
}
