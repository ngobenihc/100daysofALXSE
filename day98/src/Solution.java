import java.io.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Solution {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        /* Read input from STDIN */
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        scanner.close();

        /* Compute MD5 Hash */
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(inputString.getBytes());
        byte[] digest = md.digest();

        /* Convert byte array to hexadecimal string */
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }

        /* Print the MD5 Hash */
        System.out.println(sb.toString());
    }
}
