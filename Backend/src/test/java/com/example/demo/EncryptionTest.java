package com.example.demo;

import org.junit.Assert;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class EncryptionTest {
    @Test
    public void EncryptionTests() {
        try
        {
            String text = "Hello World";
            String key = "Bar12345Bar12345"; // 128 bit key

            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");



            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(text.getBytes());
            System.err.println(new String(encrypted));



            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(encrypted));
            System.err.println(decrypted);
            Assert.assertEquals(text, decrypted);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
