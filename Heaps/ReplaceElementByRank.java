package Heaps;

public class ReplaceElementByRank {

    // Brute
    public static int[] getRank(int nums[]) {
        int rank[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int cnt = 1;
            for (int j = 0; j < nums.length; j++) {
                if (curr > nums[j])
                    cnt++;
            }
            rank[i] = cnt;
        }
        return rank;
    }

    public static void main(String[] args) {
        int arr[] = { 20, 15, 26, 2, 98, 6 };
        int ans[] = getRank(arr);
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }
}
