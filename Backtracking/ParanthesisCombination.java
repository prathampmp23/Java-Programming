package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class ParanthesisCombination {
    public static List<String> generateParenthesis(int n) {
        // Complete the method
        List<String> ans = new ArrayList<>();
        rec(n, ans, 0, 0, "");
        return ans;
    }

    public static void rec(int n, List<String> ans, int open, int close, String str) {
        if (str.length() == 2 * n) {
            ans.add(str);
            return;
        }
        // choose opening
        if (open < n) rec(n, ans, open + 1, close, str + "(");
        
        // choose closing
        if (close < open) rec(n, ans, open, close + 1, str + ")");
    }

    public static void main(String[] args) {
        List<String> ans = generateParenthesis(3);
        // System.out.println(ans);
        for (String s: ans) {
            System.out.println(s);
        }
    }
}
