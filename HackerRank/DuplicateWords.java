package HackerRank;

import java.util.Scanner;
import java.util.LinkedHashMap;

public class DuplicateWords {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();
            String[] words = input.split("\\s+");
            LinkedHashMap<String, String> uniqueWords = new LinkedHashMap<>();

            for (String word : words) {
                String lowerCaseWord = word.toLowerCase();
                if (!uniqueWords.containsKey(lowerCaseWord)) {
                    uniqueWords.put(lowerCaseWord, word); 
                }
            }

            StringBuilder result = new StringBuilder();
            for (String originalWord : uniqueWords.values()) {
                result.append(originalWord).append(" ");
            }

            System.out.println(result.toString().trim());
        }

        in.close();
    }
}

