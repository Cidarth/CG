package HackerRank;

import java.io.*;
import java.security.*;
import java.util.*;

public class md5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); // Read input
        scanner.close();

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            System.out.println(hexString.toString());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("MD5 algorithm not found.");
        }
    }
}
