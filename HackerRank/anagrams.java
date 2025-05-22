package HackerRank;

import java.util.Scanner;

public class anagrams {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        a = a.toLowerCase();
        b = b.toLowerCase();
        if (a.length() != b.length()) {
            return false;
        }
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        java.util.Arrays.sort(aArray);
        java.util.Arrays.sort(bArray);
        return java.util.Arrays.equals(aArray, bArray);
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
