package Strings;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        // Assume the first string is the prefix
        String prefix = strs[0];
        
        // Compare with each string
        for (int i = 1; i < strs.length; i++) {
            // Reduce prefix until it matches the current string's beginning
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        
        return prefix;
    }
    public static void main(String[] args) {
        String[] str = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(str));
    }
}
