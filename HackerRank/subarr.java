package HackerRank;

import java.util.*;

public class subarr {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        int negativeSubarrayCount = 0;

        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            
            for (int j = i; j < n; j++) {
                currentSum += arr[j];  

                if (currentSum < 0) {
                    negativeSubarrayCount++;  
                }
            }
        }
        System.out.println(negativeSubarrayCount);
        scan.close();
    }
}

