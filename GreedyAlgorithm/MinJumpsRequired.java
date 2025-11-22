package GreedyAlgorithm;

public class MinJumpsRequired {
    public static int jump(int[] nums) {
        int jumps = 0, l = 0, r = 0;
        while (r < nums.length - 1) {
            int farthest = 0;
            for (int idx = l; idx <= r; idx++) {
                farthest = Math.max(nums[idx] + idx, farthest);
            }
            l = r + 1;
            r = farthest;
            jumps++;
        }
        return jumps;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 3, 1, 1, 4 };
        System.out.println(jump(nums));
    }
}
