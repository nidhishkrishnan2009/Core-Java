package com.learning.encryption;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class DigitalSignature {

    private static Signature sign = null;

    static {
        try {
            sign = Signature.getInstance("SHA256withDSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            KeyPair keyPair = generateKeyPair();
            String message="Hi how are you";
            byte[] digitallySignedMsg = generateDigitalSignedMessage(keyPair.getPrivate(), message);
            System.out.println("Digitally Signed Message===>" + new String(digitallySignedMsg, StandardCharsets.UTF_8));
            String result = verifyDigitalSignature(keyPair.getPublic(), digitallySignedMsg,message) ? "Succesfully verfied" : "Verification failed";
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
        keyPairGen.initialize(2048);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        return keyPair;
    }

    public static byte[] generateDigitalSignedMessage(PrivateKey privateKey, String message) throws InvalidKeyException, SignatureException, UnsupportedEncodingException {
        sign.initSign(privateKey);
        sign.update(message.getBytes());
        return sign.sign();
    }

    public static boolean verifyDigitalSignature(PublicKey publicKey, byte[] digitallySignedMsg,String message) throws InvalidKeyException, SignatureException {
        sign.initVerify(publicKey);
        sign.update(message.getBytes());
        return sign.verify(digitallySignedMsg);
    }
}
