package HackerRank;

import java.util.*;


public class eof1 {
    public static void main(String[] args) {
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        for (int i= 1; s.hasNext(); i++){
            String n = s.nextLine();
            System.out.println(i+" "+ n);
        }
        s.close();
    }
}
