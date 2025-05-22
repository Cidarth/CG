package HackerRank;

import java.util.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    public int compare(Player a, Player b) {
        if (a.score != b.score) {
            return b.score - a.score; 
        } else {
            return a.name.compareTo(b.name);
        }
    }
}

public class comparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Player[] players = new Player[n];
        
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            players[i] = new Player(name, score);
        }
        sc.close();

        Arrays.sort(players, new Checker());

        for (Player p : players) {
            System.out.println(p.name + " " + p.score);
        }
    }
}
