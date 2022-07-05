//package com.dailycodebuffer.springboot.tutorial.config;
//
//import org.springframework.context.annotation.Configuration;
//
//import javax.crypto.*;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.security.*;
//import java.security.spec.EncodedKeySpec;
//import java.security.spec.InvalidKeySpecException;
//import java.security.spec.PKCS8EncodedKeySpec;
//import java.security.spec.X509EncodedKeySpec;
//import java.util.Base64;
//@Configuration
//public class RSA {
//    private PrivateKey privateKey;
//    private PublicKey publicKey;
//
//    public RSA() throws NoSuchAlgorithmException, FileNotFoundException {
//        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
//        generator.initialize(2048);
//        KeyPair pair = generator.generateKeyPair();
//        PrivateKey privateKey = pair.getPrivate();
//        PublicKey publicKey = pair.getPublic();
//        try (FileOutputStream fos = new FileOutputStream("public.key")) {
//            fos.write(publicKey.getEncoded());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        try (FileOutputStream fos = new FileOutputStream("private.key")) {
//            fos.write(privateKey.getEncoded());
//        }catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public PublicKey getPublic() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
//        File publicKeyFile = new File("public.key");
//        byte[] publicKeyBytes = Files.readAllBytes(publicKeyFile.toPath());
//        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
//        return keyFactory.generatePublic(publicKeySpec);
//
//    }
//
//    public PrivateKey getPrivate() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
//        File privateKeyFile = new File("private.key");
//        byte[] privateKeyBytes = Files.readAllBytes(privateKeyFile.toPath());
//        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
//        return keyFactory.generatePrivate(privateKeySpec);
//
//    }
//
//    public String encrypt(String plainData) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, IOException {
//        Cipher encryptCipher = Cipher.getInstance("RSA");
//        encryptCipher.init(Cipher.ENCRYPT_MODE, getPublic());
//        byte[] secretMessageBytes = plainData.getBytes(StandardCharsets.UTF_8);
//        byte[] encryptedMessageBytes = encryptCipher.doFinal(secretMessageBytes);
//        return Base64.getEncoder().encodeToString(encryptedMessageBytes);
//    }
//
//    public String decrypt(String cipherData) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, IOException {
//        Cipher encryptCipher = Cipher.getInstance("RSA");
//        encryptCipher.init(Cipher.DECRYPT_MODE, getPrivate());
//        byte[] secretMessageBytes = cipherData.getBytes(StandardCharsets.UTF_8);
//        byte[] decryptedMessageBytes = encryptCipher.doFinal(Base64.getDecoder().decode(secretMessageBytes));
//        return new String(decryptedMessageBytes, StandardCharsets.UTF_8);
//    }
//}
