import java.util.ArrayList;

public class PrintPatternMin5 {

    public static void printPatternHelper(int n, int curr, ArrayList<Integer> res) {
        res.add(curr);
        if (curr <= 0)
            // But after reaching -3, the methods return upward:
            // -3 → 2 → 7 → 12 → 17
            return;

        // The recursive call goes down:
        // 17 → 12 → 7 → 2 → -3
        printPatternHelper(n, curr - 5, res);
        res.add(curr); // reverse call curr is added here → 2 → 7 → 12 → 17
    }

    public static ArrayList<Integer> pattern(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        printPatternHelper(n, n, res);
        return res;
    }

    public static void main(String[] args) {
        /*
         * Given a number n, print a sequence of numbers starting from n. Each next
         * number in the sequence is n - 5, and this continues recursively until the
         * number becomes less than or equal to 0. After that, print the sequence in
         * reverse order, adding 5 each time, until it reaches back to the original
         * number n.
         * Note: You must not use loops.
         * 
         * Examples:
         * Input: n = -16
         * Output: [-16]
         * Explanation: Since -16 is less than zero so it will remain same.
         * 
         * Input: n = 10
         * Output: [10, 5, 0, 5, 10]
         * Explanation: The value decreases until it is greater or equal to 0. After
         * that it increases and stops when it becomes 10 again.
         */
        ArrayList<Integer> list = pattern(17);
        System.out.println(list);
    }

}