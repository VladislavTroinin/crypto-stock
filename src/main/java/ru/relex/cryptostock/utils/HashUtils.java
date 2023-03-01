package ru.relex.cryptostock.utils;

import lombok.SneakyThrows;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class HashUtils {

    private final static String globalKey = "r2Hc30vy13VByDUD5OrlpGrmVPrOyfwk";


    @SneakyThrows       // todo
    public static String encrypt(String text) {
        Key aesKey = new SecretKeySpec(globalKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        byte[] encryptedBytes = cipher.doFinal(text.getBytes());
        return DatatypeConverter.printBase64Binary(encryptedBytes);
    }

    @SneakyThrows       // todo
    public static String decrypt(String token) {
        Key aesKey = new SecretKeySpec(globalKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        byte[] tokenBytes = DatatypeConverter.parseBase64Binary(token);
        return new String(cipher.doFinal(tokenBytes));
    }

}
