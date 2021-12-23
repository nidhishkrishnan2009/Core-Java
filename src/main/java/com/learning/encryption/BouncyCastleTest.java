package com.learning.encryption;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class BouncyCastleTest {
    private static final char[] KEYSTORE_PASSWORD="Nidish123".toCharArray();
    private static final char[] PRIVATE_KEY_PASSWORD="pass".toCharArray();
    private static final String DESTINATION_PATH="src/main/resources/bouncyCastle/";
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Security.setProperty("crypto.policy", "unlimited");
        int maxKeySize = javax.crypto.Cipher.getMaxAllowedKeyLength("AES");
        System.out.println("Max Key Size for AES : " + maxKeySize);
        try {
            generateCertAndPrivateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void generateCertAndPrivateKey() throws CertificateException, NoSuchProviderException, IOException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        Security.addProvider(new BouncyCastleProvider());
        CertificateFactory certFactory=CertificateFactory.getInstance("X.509","BC");
        File certFile=new File(DESTINATION_PATH+"Baeldung.cer");
        certFile.createNewFile();
        X509Certificate certificate=(X509Certificate) certFactory.generateCertificate(new FileInputStream(certFile));
        KeyStore keystore=KeyStore.getInstance("PKCS12");
        File privateKeyFile=new File(DESTINATION_PATH+"Baeldung.p12");
        privateKeyFile.createNewFile();
        keystore.load(new FileInputStream((privateKeyFile)),KEYSTORE_PASSWORD);
        PrivateKey privateKey=(PrivateKey) keystore.getKey("myKey1",PRIVATE_KEY_PASSWORD);
    }
}
