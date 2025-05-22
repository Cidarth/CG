package HackerRank;

import java.io.*;
import java.util.*;

public class arr1 {

    public static boolean canWin(int leap, int[] game) {
        return canWinFrom(0, game, leap, new boolean[game.length]);
    }

    private static boolean canWinFrom(int i, int[] game, int leap, boolean[] visited) {
        // Base cases
        if (i >= game.length) return true;        // We've jumped/walked off the array
        if (i < 0 || game[i] == 1 || visited[i]) return false;  // Invalid move or already visited

        visited[i] = true; // Mark current cell as visited

        // Try all possible moves from current position
        return canWinFrom(i + leap, game, leap, visited) ||
               canWinFrom(i + 1, game, leap, visited) ||
               canWinFrom(i - 1, game, leap, visited);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();  // Number of queries

        while (q-- > 0) {
            int n = sc.nextInt();  // Length of game array
            int leap = sc.nextInt();  // Leap distance
            int[] game = new int[n];

            for (int i = 0; i < n; i++) {
                game[i] = sc.nextInt();
            }

            System.out.println(canWin(leap, game) ? "YES" : "NO");
        }

        sc.close();
    }
}

