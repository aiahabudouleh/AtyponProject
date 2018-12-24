package utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Crypto {

    /**
     * @param password
     */
    public static String encryptThisString(String password) {
        try {
            // getInstance() method is called with algorithm SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(password.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            // return the HashText
            return hashtext;

        } catch (Exception e) {
            System.out.println("Error : SHA1 Digest ");
            System.out.println(e.getMessage());
        }

        return "non";
    }

}


