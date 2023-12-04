package Conect;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {
    public static String generate(String email){
        try {
            MessageDigest men = MessageDigest.getInstance("SHA-1");
            men.update(email.getBytes());
            byte[] digest = men.digest();
            String a = new BigInteger(1, digest).toString(16).toUpperCase();
            return a;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String senha(String senha){
        try {
            MessageDigest men = MessageDigest.getInstance("SHA-256");
            men.update(senha.getBytes());
            byte[] digest = men.digest();
            String a = new BigInteger(1, digest).toString(16).toUpperCase();
            return a;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}