package ArrayList;

import java.util.ArrayList;
import java.util.HashMap;

public class MostFrequentNumCnt {
    public static int[] mostFrequent(int[] arr) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        int maxf = 0;

        for (int num : map.keySet()) {
            maxf = Math.max(maxf, map.get(num));
        }

        for (int num : map.keySet()) {
            if (map.get(num) == maxf) {
                list.add(num);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int num : list) {
            ans = Math.min(ans, num);
        }

        return new int[] { ans, maxf };
    }

    public static void main(String[] args) {
        int ans[] = mostFrequent(new int[] { 1, 2, 1, 3, 1, 2, 2, 4 });
        System.out.println(ans[0] + "," + ans[1]);
    }
}
