package com.learning.encryption;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;

public class KeyStoreLearning {
    private static final char[] KEYSTORE_PASSWORD="changeit".toCharArray();
    private static final String JAVA_CERT_PATH="/Users/nidishkrishnan/Desktop/cacerts";
    private static final String MY_CERT_PASS="nidish";
    private static final String DESTINATION_PATH="src/main/resources/JCA/";
    public static void main(String[] args) {
        try {
            storingIntoKeyStyore();
            retreiveKeyFromKeyStore();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnrecoverableEntryException e) {
            e.printStackTrace();
        }
    }
    public static void storingIntoKeyStyore() throws IOException, CertificateException, KeyStoreException, NoSuchAlgorithmException {
       KeyStore keyStore=setKeyStore();
        FileOutputStream fos=new FileOutputStream(DESTINATION_PATH+"myKeytsore");
        keyStore.store(fos,KEYSTORE_PASSWORD);
        System.out.println("Data Stored");
    }

    public static void retreiveKeyFromKeyStore() throws CertificateException, KeyStoreException, IOException, NoSuchAlgorithmException, UnrecoverableEntryException {
        KeyStore keyStore=setKeyStore();
        KeyStore.ProtectionParameter protectionParameter=new KeyStore.PasswordProtection(KEYSTORE_PASSWORD);
        KeyStore.SecretKeyEntry secretKeyEntry= (KeyStore.SecretKeyEntry) keyStore.getEntry("nidishKeyEntry",protectionParameter);
        SecretKey secretKey=secretKeyEntry.getSecretKey();
        System.out.println("Algorithm==>"+secretKey.getAlgorithm());
        System.out.println("Format==>"+secretKey.getFormat());
        System.out.println("Encoded===>"+secretKey.getEncoded().toString());
    }

    public static KeyStore setKeyStore() throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException {
        KeyStore keyStore=KeyStore.getInstance("JCEKS");
        FileInputStream fis=new FileInputStream(JAVA_CERT_PATH);
        keyStore.load(fis,KEYSTORE_PASSWORD);
        KeyStore.ProtectionParameter protectionParameter=new KeyStore.PasswordProtection(KEYSTORE_PASSWORD);
        SecretKey secretKey=new SecretKeySpec(MY_CERT_PASS.getBytes(),"DSA");
        KeyStore.SecretKeyEntry secretKeyEntry=new KeyStore.SecretKeyEntry(secretKey);
        keyStore.setEntry("nidishKeyEntry",secretKeyEntry,protectionParameter);
        return keyStore;
    }
}
