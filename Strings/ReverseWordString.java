package Strings;

public class ReverseWordString {

    public static String reverseWords(String s) {
        String ans = "";
        String[] words = s.trim().split("\\s+");

        for (int i = words.length - 1; i >= 0; i--) {
            ans = ans + words[i];
            ans = ans + " ";
        }
        return ans.trim();
    }

    public static String reverseWords1(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) sb.append(" "); 
        }

        return sb.toString();
    }
    

    public static void main(String[] args) {
        String str1 = "the sky is blue";
        String str2 = "  hello world  ";
        String str3 = "a good   example";

        System.out.println(reverseWords(str1));
        System.out.println(reverseWords(str2));
        System.out.println(reverseWords(str3));
    }
}
