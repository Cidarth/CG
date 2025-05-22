package HackerRank;

import java.io.*;
import java.util.*;

public class hashset {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        
        Set<String> uniquePairs = new HashSet<>();
        
        for (int i = 0; i < t; i++) {
            String left = s.next();
            String right = s.next();
            
            String pair = left.compareTo(right) < 0 ? left + " " + right : right + " " + left;
            
            uniquePairs.add(pair);            
            System.out.println(uniquePairs.size());
        }
        s.close();
    }
}
