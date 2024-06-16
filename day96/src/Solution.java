import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        // Read input from standard input
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        scanner.close();

        try {
            // Create SHA-256 Hash
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(inputString.getBytes());

            // Convert the byte array into a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            // Print the SHA-256 hash value
            System.out.println(hexString.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
