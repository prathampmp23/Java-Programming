package Arrays1D;

public class GetNoZeroNum {
    public static int[] getNoZeroIntegers(int n) {
        int ans[] = new int[2];
        for (int i = 1; i < n; i++) {
            int p = i;
            int q = n - p;
            if (!containsZero(p) && !containsZero(q)) {
                ans[0] = p;
                ans[1] = q;
                break;
            }
        }
        return ans;
    }

    public static boolean containsZero(int num) {
        while (num > 0) {
            if (num % 10 == 0)
                return true;
            num /= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        int ans[] = getNoZeroIntegers(11);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
