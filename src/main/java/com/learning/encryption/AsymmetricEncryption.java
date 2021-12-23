package com.learning.encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;

public class AsymmetricEncryption {
    private static Cipher cipher;

    static {
        try {
            cipher = Cipher.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String message="Welcome to Tutorialspoint";
        try {
            KeyPair key=generateKey();
            byte[] cipherText=encryptData(message, key.getPublic());
            System.out.println("Encrypted data===>"+new String(cipherText,"UTF8"));
            String decryptedData=decryptData(cipherText, key.getPrivate());
            System.out.println("Decrypted Data===>"+decryptedData);
        }
        catch (Exception e){

        }
    }

    public static byte[] encryptData(String message, PublicKey key) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.ENCRYPT_MODE,key);
        cipher.update(message.getBytes());
        byte[] cipherText=cipher.doFinal();
        return cipherText;
    }
    public static String decryptData(byte[]cipherText,PrivateKey privateKey) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        cipher.update(cipherText);
        byte[] output=cipher.doFinal();
        return new String(output,"UTF8");
    }
    public static KeyPair generateKey() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGen=KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        return keyPairGen.generateKeyPair();
    }
}
