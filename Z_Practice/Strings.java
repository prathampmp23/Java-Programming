package Z_Practice;

import java.util.Arrays;
import java.util.Scanner;

public class Strings {

    public static void printLetters(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    }

    public static void isPalindrome(String str) {
        boolean isPalindrome = false;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) == str.charAt(str.length() - 1 - i)) {
                isPalindrome = true;
            } else {
                isPalindrome = false;
            }
        }
        if (isPalindrome) {
            System.out.println("String is palindrome");
        } else {
            System.out.println("String is not palindrome");
        }
    }

    public static boolean isPalindrome2(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static float getShortestPath(String path) {
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            char dir = path.charAt(i);
            if (dir == 'N') {
                y++;
            } else if (dir == 'S') {
                y--;
            } else if (dir == 'E') {
                x++;
            } else {
                x--;
            }
        }
        int X2 = x * x;
        int Y2 = y * y;

        return (float) Math.sqrt(X2 + Y2);
    }

    public static String subString(String str, int si, int ei) {
        String subStr = "";
        for (int i = si; i < ei; i++) {
            subStr += str.charAt(i);
        }
        return subStr;
    }

    public static String toUppercase(String str) {
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String stringCompression(String str) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if (count > 1) {
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }

    public static void countVovels(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (
                str.charAt(i) == 'a' ||
                str.charAt(i) == 'e' || 
                str.charAt(i) == 'i' || 
                str.charAt(i) == 'o' || 
                str.charAt(i) == 'u'
                ) {
                count++;
            }
        }
        if (count > 0) {
            System.out.println("Total vovels in string are " + count);
        } else {
            System.out.println("String don't contain any vovels");
        }
    }

    public static void isAnagrams(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if(len1 == len2) {

            str1.toLowerCase();
            str2.toLowerCase();

            char[] str1toarray = str1.toCharArray();
            char[] str2toarray = str2.toCharArray();

            Arrays.sort(str1toarray);
            Arrays.sort(str2toarray);

            boolean result = Arrays.equals(str1toarray , str2toarray);
            if(result){
                System.out.println("It is a anagrams.");
            } else {
                System.out.println("It is not a anagrams.");
            }
        } else {
            System.out.println("It is not a anagrams.");
        }
    }

    public static void main(String[] arr) {

        // "Strings are immutable"
        // * Declaration -
        String str1 = "abcd";
        String str2 = new String("abcd");

        System.out.println(str1);
        System.out.println(str2);

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name ");
        // String name = sc.next(); // it take single word as input
        String name = sc.nextLine(); // it take line as input

        System.out.println("Your name is " + name);
        System.out.println("Length of string is = " + name.length());

        // concatenation
        String firstname = "Pratham";
        String lastname = "Potdar";
        String fullName = firstname + " " + lastname;
        System.out.println(fullName);

        // charAt() method
        System.out.println(name.charAt(0));
        sc.close();

        // Print string letters
        printLetters(fullName);

        // Palindrome
        String strg = "racecar";
        isPalindrome(strg);
        // or
        if (isPalindrome2(strg)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not palindrome");
        }

        // Shortest path to reach destination
        String path = "WNEENESENNN";
        System.out.println("Shortest path is = " + getShortestPath(path));

        // Compare string
        String s1 = "Tony";
        String s2 = "Tony";
        String s3 = new String("Tony");

        if (s1 == s2) {
            System.out.println("String are equal");
        } else {
            System.out.println("String are not equal");
        }

        if (s1 == s3) {
            System.out.println("String are equal");
        } else {
            System.out.println("String are not equal");
        }
        // equals()
        if (s1.equals(s3)) {
            System.out.println("String are equal");
        } else {
            System.out.println("String are not equal");
        }

        // Substring
        String hello = "HelloWorld";
        System.out.println(subString(hello, 0, 5));
        System.out.println(hello.substring(0, 5));

        // compareTo()
        String fruits[] = { "apple", "mango", "banana" };
        String largest = fruits[0];
        // Time complexity = O(x*n) x -> largest string, n = no of string
        for (int i = 1; i < fruits.length; i++) {
            if (largest.compareTo(fruits[i]) < 0) {
                largest = fruits[i];
            }
        }
        System.out.println(largest);

        // StringBuilder
        StringBuilder sb = new StringBuilder("");
        // Time complexity = O(26)
        for (char ch = 'a'; ch <= 'z'; ch++) {
            sb.append(ch);
        }
        System.out.println(sb);
        System.out.println(sb.length());

        // conversion of first letter to uppercase
        String sentence = "hi, i am pratham potdar";
        System.out.println(toUppercase(sentence));

        // String Compression
        String toCompress = "aaabbcccdd"; // o/p - a3b2c3d2
        System.out.println(stringCompression(toCompress));

        // Count vovels 
        String vovelsStr = "aeiou";
        countVovels(vovelsStr);

        // To check is two string is anagrams or not
        isAnagrams("race", "care");
    }
}