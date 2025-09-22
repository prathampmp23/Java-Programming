package Arrays1D;

public class FindSqrt {

    public static long floorSqrt(long n) {
        return (long) Math.sqrt(n);
    }

    public static long floorSqrt2(long n) {
        int ans = 0;
        long low = 1;
        long high = n;
        while (low <= high) {
            long mid = (low + high) / 2;
            if ((mid * mid) <= n) {
                ans = (int) mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int floorRoot(int N, int M) {
        int ans = -1;
        int low = 1;
        int high = N;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (Math.pow(N, N) <= M) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(floorSqrt(36));
        System.out.println(floorSqrt2(36));

        System.out.println(floorRoot(3, 27));
    }
}