package HackerRank;

import java.util.BitSet; import java.util.Scanner;

public class bitset {

public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int M = scanner.nextInt();

    BitSet[] B = new BitSet[]{new BitSet(N), new BitSet(N)};

    for( int i=0; i<M; i++ ) {

        String cmd = scanner.next();
        int left = scanner.nextInt()-1;
        int right = scanner.nextInt()-1;

        switch( cmd ) {
            case "AND" -> B[left].and(B[right]); 
            case "OR" -> B[left].or(B[right]);
            case "XOR" -> B[left].xor(B[right]);
            case "SET" -> B[left].set(right+1); 
            case "FLIP" -> B[left].flip(right+1); 
            default -> {}
        }                        

        System.out.print(B[0].cardinality());
        System.out.print(" ");
        System.out.print(B[1].cardinality());
        System.out.println();
    }       
    scanner.close();

}
}
