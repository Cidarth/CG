package HackerRank;

import java.util.Scanner;

public class DataTypeFitChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine()); 
        for (int i = 0; i < t; i++) {
            String value = scanner.nextLine(); 
            try {
                long n = Long.parseLong(value); 

                System.out.println(value + " can be fitted in:");
                if (n >= Byte.MIN_VALUE && n <= Byte.MAX_VALUE) {
                    System.out.println("* byte");
                }
                if (n >= Short.MIN_VALUE && n <= Short.MAX_VALUE) {
                    System.out.println("* short");
                }
                if (n >= Integer.MIN_VALUE && n <= Integer.MAX_VALUE) {
                    System.out.println("* int");
                }
                System.out.println("* long");
            } catch (NumberFormatException e) {
                System.out.println(value + " can't be fitted anywhere.");
            }
        }

        scanner.close();
    }
}
