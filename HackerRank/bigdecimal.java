package HackerRank;

import java.math.BigDecimal;
import java.util.*;

public class bigdecimal {
    public static void main(String[] args) {
        // Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        // Sort using a custom comparator
        Arrays.sort(s, new Comparator<String>() {
            public int compare(String a, String b) {
                BigDecimal bdA = new BigDecimal(a);
                BigDecimal bdB = new BigDecimal(b);
                return bdB.compareTo(bdA); // Descending order
            }
        });

        // Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}
