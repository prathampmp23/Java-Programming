import java.util.HashSet;

public class Unique3DigitEvenPermutation {

    public static HashSet<Integer> set = new HashSet<>();

    public static int totalNumbers(int[] digits) {
        boolean used[] = new boolean[digits.length];
        permutation(digits, 0, 0, used);
        return set.size();
    }

    public static void permutation(int digits[], int idx, int ans, boolean used[]) {
        if (idx == 3) {
            if (ans % 2 == 0)
                set.add(ans);
            return;
        }
        for (int i = 0; i < digits.length; i++) {
            if (used[i] == true)
                continue;

            int curr = digits[i];
            if (curr == 0 && idx == 0) {
                continue;
            }
            used[i] = true;
            int newans = ans * 10 + curr;
            permutation(digits, idx + 1, newans, used);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        permutation(arr, 0, 0, new boolean[26]);
        System.out.println(set);
    }
}