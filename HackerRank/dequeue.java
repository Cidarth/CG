package HackerRank;

import java.util.*;

public class dequeue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Total number of elements
        int m = sc.nextInt(); // Size of subarray
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            // Add current number to deque and map
            deque.addLast(num);
            map.put(num, map.getOrDefault(num, 0) + 1);

            // If deque size exceeds the window size, remove the oldest
            if (deque.size() > m) {
                int removed = deque.removeFirst();
                int count = map.get(removed);
                if (count == 1) {
                    map.remove(removed);
                } else {
                    map.put(removed, count - 1);
                }
            }

            // Update max unique count once window reaches size m
            if (deque.size() == m) {
                maxUnique = Math.max(maxUnique, map.size());
            }
        }

        System.out.println(maxUnique);
        sc.close();
    }
}
