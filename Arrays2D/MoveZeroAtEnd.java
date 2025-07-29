package Arrays2D;

public class MoveZeroAtEnd {
    // BruteForce
    public static void moveZeroes(int[] nums) {
        if (nums.length == 1)
            return;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }
        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }
    
    // optimal
    public static void moveZeroes2(int[] nums) {
       int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        if (j == -1)
            return;

        for (int i = j + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }


    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 3, 12 };
        // moveZeroes(arr);
        moveZeroes2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
