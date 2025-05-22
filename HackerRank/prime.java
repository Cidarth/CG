package HackerRank;

import java.io.*;
import java.math.*;


public class prime {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String n = bufferedReader.readLine();

        bufferedReader.close();
        BigInteger num = new BigInteger(n);

        if (num.isProbablePrime(100)) {  
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
    }
}

