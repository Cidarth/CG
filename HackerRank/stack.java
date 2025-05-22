package HackerRank;

import java.io.*;
import java.util.*;

public class stack{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(isBalanced(input));
        }

        sc.close();
    }

    private static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            switch (ch) {
                case '(': case '{': case '[':
                    stack.push(ch);
                    break;

                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;

                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    break;

                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;

                default:
                    return false; // if the input contains invalid characters
            }
        }

        return stack.isEmpty(); // true if all brackets are matched
    }
}
