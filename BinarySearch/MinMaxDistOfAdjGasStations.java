public class MinMaxDistOfAdjGasStations {
    public double minMaxDist(int[] stations, int k) {
        // code here
        double l = 0;
        double r = 0;
        for (int i = 1; i < stations.length; i++) {
            r = Math.max(r, stations[i] - stations[i - 1]);
        }

        while ((r - l) > 1e-6) {
            double mid = (l + r) / 2.0;
            if (isPossible(stations, mid, k)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return r;
    }

    public boolean isPossible(int stations[], double mid, int k) {
        int cnt = 0;
        for (int i = 1; i < stations.length; i++) {
            cnt += Math.floor((stations[i] - stations[i - 1]) / mid);
        }
        return cnt <= k;
    }

    public static void main(String[] args) {
        /*
         * We have a horizontal number line. On that number line, we have gas stations
         * at positions stations[0], stations[1], ..., stations[n-1]. Now, we add k more
         * gas stations so that d, the maximum distance between adjacent gas stations is
         * minimized. Find the smallest possible value of d. Find the answer exactly to
         * 6 decimal places.
         * Note: stations sorted is in a strictly increasing order.
         * 
         * Examples:
         * 
         * Input: stations[] = [1, 2, 3, 4, 5], k = 2
         * Output: 1.00
         * Explanation: Since all gaps are already equal (1 unit each), adding extra
         * stations in between does not reduce the maximum distance.
         * 
         * Input: stations[] = [3, 6, 12, 19, 33], k = 3
         * Output: 6.00
         * Explanation: The largest gap is 14 (between 19 and 33). Adding 2 stations
         * there splits it into approx 4.67. The next largest gap is 7 (between 12 and
         * 19). Adding 1 station splits it into 3.5. Now the maximum gap left is 6.
         * 
         * Constraints:
         * 2 ≤ stations.size() ≤ 105
         * 0 ≤ stations[i] ≤ 106
         * 0 ≤ k ≤ 105
         */
    }
}
