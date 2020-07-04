import static java.lang.System.out;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Java String Encryption Decryption Example
 * @author Ramesh Fadatare
 *
 */
public class AESEncryptionDecryption {
    private static SecretKeySpec secretKey;
    private static byte[] key;
    private static final String ALGORITHM = "AES";

    public void prepareSecreteKey(String myKey) {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String strToEncrypt, String secret) {
        try {
            prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public String decrypt(String strToDecrypt, String secret) {
        try {
            prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
    private String encryp;

    public String getEncryp() {
        return encryp;
    }

    public void setEncryp(String encryp) {
        this.encryp = encryp;
    }
    private String original;

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }
    

    public static void main(String[] args) {
        final String secretKey = "secrete";

        

        AESEncryptionDecryption aesEncryptionDecryption = new AESEncryptionDecryption();
        String originalString = "javaguidescc";
        String encryptedString = aesEncryptionDecryption.encrypt(originalString, secretKey);
        String decryptedString = aesEncryptionDecryption.decrypt(encryptedString, secretKey);
aesEncryptionDecryption.setEncryp(encryptedString);
        System.out.println(originalString);
       System.out.println(encryptedString);
       System.out.println(decryptedString);
    }
}