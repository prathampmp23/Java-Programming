package GreedyAlgorithm;

public class CanJumps {
    public static boolean canJump(int[] nums) {
        int reachIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (reachIdx < i)
                return false;
            reachIdx = Math.max(reachIdx, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 3, 1, 1, 4 };
        System.out.println(canJump(nums));
    }
}
