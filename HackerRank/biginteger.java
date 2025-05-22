package HackerRank;

import java.util.*;
import java.math.*;

public class biginteger {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        String num1 = sc.nextLine();
        String num2 = sc.nextLine();
        
        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        
        BigInteger sum = a.add(b);
        BigInteger product = a.multiply(b);
        
        System.out.println(sum);        
        System.out.println(product);    
        
        sc.close();
    }
}   
