public class PaintersPartition {
    public int minTime(int[] arr, int k) {
        // code here
        long l = 0;
        long r = 0;
        for (int a : arr) {
            l = Math.max(l, a);
            r += a;
        }
        while (l <= r) {
            long mid = (l + r) >> 1; // divide by 2
            int newK = isPossible(arr, mid);
            if (newK <= k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

    public int isPossible(int arr[], long mid) {
        long sum = 0;
        int partition = 1;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] > mid) {
                sum = arr[i];
                partition++;
            } else {
                sum += arr[i];
            }
        }
        return partition;
    }

    public static void main(String[] args) {
        /*
         * Given an array arr[] where each element denotes the length of a board, and an
         * integer k representing the number of painters available. Each painter takes 1
         * unit of time to paint 1 unit length of a board.
         * 
         * Determine the minimum amount of time required to paint all the boards, under
         * the constraint that each painter can paint only a contiguous sequence of
         * boards (no skipping or splitting allowed).
         * 
         * Examples:
         * 
         * Input: arr[] = [5, 10, 30, 20, 15], k = 3
         * Output: 35
         * Explanation: The optimal allocation of boards among 3 painters is -
         * Painter 1 → [5, 10] → time = 15
         * Painter 2 → [30] → time = 30
         * Painter 3 → [20, 15] → time = 35
         * Job will be done when all painters finish i.e. at time = max(15, 30, 35) = 35
         * 
         * Input: arr[] = [10, 20, 30, 40], k = 2
         * Output: 60
         * Explanation: A valid optimal partition is -
         * Painter 1 → [10, 20, 30] → time = 60
         * Painter 2 → [40] → time = 40
         * Job will be complete at time = max(60, 40) = 60
         * 
         * Input: arr[] = [100, 200, 300, 400], k = 1
         * Output: 1000
         * Explanation: There is only one painter, so the painter must paint all boards
         * sequentially. The total time taken will be the sum of all board lengths,
         * i.e., 100 + 200 + 300 + 400 = 1000.
         */
    }
}
