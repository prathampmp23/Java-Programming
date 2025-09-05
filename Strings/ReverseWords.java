package Strings;

public class ReverseWords {

    /*
     * split("\\s+")
     * 
     * split() splits a string into an array of substrings based on a regular
     * expression (regex).
     * 
     * The regex "\\s+" means:
     *  \s → any whitespace character (space, tab, newline, etc.)
     *  + → one or more occurrences of the preceding pattern
     *  "\\s+" → in Java, we need double backslashes because \ is an escape character
     *  in strings.
     * 
     * So this will split the string wherever one or more whitespace characters
     * appear.
     */
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(s);
        System.out.println(reverseWords(s));
    }
}
