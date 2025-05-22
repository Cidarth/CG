package HackerRank;

import java.io.*;
import java.util.*;

public class primechecker {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // use System.in explicitly
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            
            Prime ob = new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);

        } catch(Exception e){
            System.out.println(e);
        }
    }
}

class Prime {
    public void checkPrime(int... numbers) {
        for (int n : numbers) {
            if (isPrime(n)) {
                System.out.print(n + " ");
            }
        }
        System.out.println(); // newline after each call
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

