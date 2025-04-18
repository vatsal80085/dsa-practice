package dsaPractice;

import java.util.*;

public class q12 {
    public static String reverseWords(String s) {
        // Trim leading/trailing spaces and split by one or more spaces
        String[] words = s.trim().split("\\s+");
        
        // Convert array to a mutable list and reverse it
        List<String> wordList = Arrays.asList(words);
        Collections.reverse(wordList);
        
        // Join words with a space
        return String.join(" ", wordList);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  Hello   World  ")); // Output: "World Hello"
        System.out.println(reverseWords("Java is fun"));       // Output: "fun is Java"
        System.out.println(reverseWords("  "));                // Output: ""
    }
}
