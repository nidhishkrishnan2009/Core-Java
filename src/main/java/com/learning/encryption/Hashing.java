package com.learning.encryption;

import javax.crypto.Mac;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class Hashing {
    private static final SecureRandom secureRandom=new SecureRandom();
    public static void main(String[] args) throws Exception {
        String inputMessage="Hello Nidish";
       // sha256(inputMessage);
        Key key= SymmetricEncryption.generateKey();
        MAC_MessageAuthenticationCode(inputMessage,key);
        MAC_MessageAuthenticationCode(inputMessage,key);
    }

    public static void sha256(String message) throws Exception{
        MessageDigest md=MessageDigest.getInstance("SHA-256");
        md.update(message.getBytes());
        byte[] digest=md.digest();
        String output=new String(digest, StandardCharsets.UTF_8);
        System.out.println(output);

    }

    public static void MAC_MessageAuthenticationCode(String message,Key key) throws NoSuchAlgorithmException, InvalidKeyException {

        Mac mac= Mac.getInstance("HmacSHA256");
        mac.init(key);
        byte[] finalOutput= mac.doFinal(message.getBytes());
        String output=new String(finalOutput,StandardCharsets.UTF_8);
        System.out.println(output);
    }

}
