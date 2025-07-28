package Arrays2D;

public class CheckArrayIsSorted {
    public static boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Compare current with next in circular fashion
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }
        // if count greater than one then it is not sorted
        return count <= 1;
    }

    public static void main(String[] args) {
        int arr[] = {3,4,5,1,2};
        System.out.println(check(arr));
    }
}
