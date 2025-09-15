package Strings;

import java.util.HashSet;
import java.util.Set;

public class HasBrokenWord {
    public static int canBeTypedWords(String text, String brokenLetters) {
        String words[] = text.split(" ");
        Set<Character> broken = new HashSet<>();
        for (char c : brokenLetters.toCharArray())
            broken.add(c);
        int count = 0;
        for (String word : words) {
            boolean hasBroken = false;
            for (char c : word.toCharArray()) {
                if (broken.contains(c)) {
                    hasBroken = true;
                    break;
                }
            }
            if (!hasBroken)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String text = "hello world";
        String brokenLetters = "ad";

        // count no of words can be possible to type
        System.out.println(canBeTypedWords(text, brokenLetters));
    }
}
