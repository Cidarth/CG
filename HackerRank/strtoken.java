package HackerRank;

import java.util.*;

public class strtoken {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        scan.close();
        String[] tokens = s.split("[^A-Za-z]+");
        List<String> elements = new ArrayList<>();
        for (String i : tokens) {
            if (!i.isEmpty()) {
                elements.add(i);
            }
        }
        System.out.println(elements.size());
        for (String i : elements) {
            System.out.println(i);
        }
    }
}

