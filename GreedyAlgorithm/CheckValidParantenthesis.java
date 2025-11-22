package GreedyAlgorithm;

public class CheckValidParantenthesis {
    public static boolean checkValidString(String s) {
        int low = 0;   
        int high = 0;  

        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low--;
                high--;
            } else { 
                low--;     // treat '*' as ')'
                high++;    // treat '*' as '('
            }
            if (high < 0) return false;

            low = Math.max(low, 0);
        }

        return low == 0;
    }

    public static void main(String[] args) {
        System.out.println(checkValidString("()"));
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(*))"));
        System.out.println(checkValidString("(*)))"));
    }
}
