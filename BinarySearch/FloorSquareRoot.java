public class FloorSquareRoot {
    public static int floorSqrt(int n) {
        int st = 0;
        int ed = n;
        int ans = 0;
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (mid <= n / mid) {
                ans = mid;
                st = mid + 1;
            } else
                ed = mid - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(floorSqrt(25));
        System.out.println(floorSqrt(80));
    }
}
