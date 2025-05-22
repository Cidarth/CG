package HackerRank;

import java.io.*;
import java.security.*;
import java.util.*;

public class sha256 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();  
        scanner.close();

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] hashBytes = md.digest(input.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            System.out.println(hexString.toString());

        } catch (Exception e) {
            System.out.println("An error occurred while computing the hash.");
        }
    }
}

