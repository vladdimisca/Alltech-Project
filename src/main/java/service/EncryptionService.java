package service;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

import javax.crypto.*;

import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;

public class EncryptionService {
    private static final EncryptionService encryptionServiceinstance = new EncryptionService();
    private static Cipher ecipher;
    private static Cipher dcipher;
    private static SecretKey key;

    static {
        try {
            ecipher = Cipher.getInstance("DES");
            dcipher = Cipher.getInstance("DES");
            key = KeyGenerator.getInstance("DES").generateKey();
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String str) {
        try {
            ecipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] utf8 = str.getBytes(StandardCharsets.UTF_8);
            byte[] enc = ecipher.doFinal(utf8);

            enc = BASE64EncoderStream.encode(enc);

            return new String(enc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private EncryptionService() {}

    public static EncryptionService getInstance() {
        return encryptionServiceinstance;
    }

    public String decrypt(String str) {
        try {
            dcipher.init(Cipher.DECRYPT_MODE, key);
            byte[] dec = BASE64DecoderStream.decode(str.getBytes());
            byte[] utf8 = dcipher.doFinal(dec);

            return new String(utf8, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
