package Strings;

import java.util.Scanner;

public class CountVovels {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = new String("");
        System.out.println("Enter the string :");
        str = s.nextLine();
        s.close();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        System.out.println("Count of Vovels in string is :" + count);

        String str1 = "cat and mice";
        StringBuilder result = new StringBuilder();
        String[] words = str1.split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int vowels = 0;

            for (char ch : word.toCharArray()) {
                if ("aeiouAEIOU".indexOf(ch) != -1) {
                    vowels++;
                }
            }

            if (vowels % 2 == 0) {
                word = new StringBuilder(word).reverse().toString();
            }

            if (i > 0)
                result.append(" ");
            result.append(word);
        }
        System.out.println(result.toString());
    }
}
