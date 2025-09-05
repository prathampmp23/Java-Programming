package Arrays1D;

import java.util.HashMap;

public class SubArrayXOR {
    // Brute
    public static int solve(int[] A, int B) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int xor = 0;
            for (int j = i; j < A.length; j++) {
                xor = xor ^ A[j];
                if (xor == B) {
                    count++;
                }
            }
        }
        return count;
    }

    // Prefix sum
    public static int solve2(int[] A, int B) {
        int count = 0;
        int xor = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < A.length; i++) {
            xor = xor ^ A[i];
            if (map.containsKey(xor ^ B)) {
                count += map.get(xor ^ B);
            }
            map.put(xor, map.getOrDefault(xor, 0) + 1);

        }
        return count;
    }

    public static void main(String[] args) {
        int A[] = {4, 2, 2, 6, 4};
        int B = 6;
        System.out.println(solve(A, B));
        System.out.println(solve2(A, B));
    }
}
