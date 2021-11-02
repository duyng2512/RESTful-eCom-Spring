package com.modern.api.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Configuration
@Slf4j
public class KeyStoreConfig {

    @Value("${app.security.jwt.keystore-location}")
    private String keyStorePath;

    @Value("${app.security.jwt.keystore-password}")
    private String keyStorePassword;

    @Value("${app.security.jwt.key-alias}")
    private String keyAlias;

    @Value("${app.security.jwt.private-key-passphrase}")
    private String privateKeyPassphrase;

    @Bean
    public KeyStore keyStore() {
        String keyStoreLocation = System.getProperty("user.dir") + "//src//main/resources//" + keyStorePath;
        log.debug("Key Store location {}", keyStoreLocation);
        try (FileInputStream fileStream = new FileInputStream(keyStoreLocation)) {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(fileStream, keyStorePassword.toCharArray());
            return keyStore;
        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException eK) {
            log.error("Fail to load keystore: {}", keyStorePath, eK.getCause());
        };
        throw new IllegalArgumentException("Unable to load keystore");
    }

    @Bean
    public RSAPrivateKey rsaPrivateKey(){
        try {
            Key privateKey = keyStore().getKey(keyAlias, keyStorePassword.toCharArray());
            if (privateKey instanceof RSAPrivateKey) {
                return (RSAPrivateKey) privateKey;
            }
        } catch ( KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException exception) {
            log.error("Error create RSA private key {}", keyStorePath, exception);
        }
        throw new IllegalArgumentException("Unable to load private key");
    }
    @Bean
    public RSAPublicKey rsaPublicKey(){
        try {
            Certificate certificate = keyStore().getCertificate(keyAlias);
            PublicKey publicKey = certificate.getPublicKey();
            if (publicKey instanceof RSAPublicKey) {
                return (RSAPublicKey) publicKey;
            }
        } catch ( KeyStoreException exception) {
            log.error("Error create RSA private key {}", keyStorePath, exception);
        }
        throw new IllegalArgumentException("Unable to load public key");
    }
}
