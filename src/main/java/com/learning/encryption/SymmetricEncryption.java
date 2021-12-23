package com.learning.encryption;

import javax.crypto.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


public class SymmetricEncryption {
    private static Cipher cipher;

    static {
        try {
            cipher = Cipher.getInstance("DES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String msg = "Hi how are you";
        try {
            Key key = generateKey();
            byte[] encryptedMSG = encrypt(msg, key);
            System.out.println("Encrypted MSG ===>" + encryptedMSG);
            System.out.println("Decrypted MSG ===>" + decrypt(encryptedMSG, key));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] encrypt(String msg, Key key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedMsg = cipher.doFinal(msg.getBytes());
        return encryptedMsg;
    }

    public static String decrypt(byte[] encryptedMsg, Key key) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedMsg = cipher.doFinal(encryptedMsg);
        return new String(decryptedMsg, StandardCharsets.UTF_8);
    }

    public static Key generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keygen = KeyGenerator.getInstance("DES");
        SecureRandom secureRandomNo = new SecureRandom();
        keygen.init(secureRandomNo);
        return keygen.generateKey();
    }
}
