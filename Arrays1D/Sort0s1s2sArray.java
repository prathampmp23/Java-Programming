package Arrays1D;

public class Sort0s1s2sArray {
    // Better approach T.c = O(2N)
    public static void sort0s1s2sArray(int nums[]) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                count0++;
            else if (nums[i] == 1)
                count1++;
            else
                count2++;
        }

        for (int i = 0; i < count0; i++) {
            nums[i] = 0;
        }
        for (int i = count0; i < count0 + count1; i++) {
            nums[i] = 1;
        }
        for (int i = count0 + count1; i < count0 + count1 + count2; i++) {
            nums[i] = 2;
        }
    }

    // Optimal O(N)
    public static void sort0s1s2sArray2(int nums[]) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                mid++;
                low++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = { 2, 0, 2, 1, 1, 0, 2, 1, 0, 0, 1, 2 };
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        sort0s1s2sArray(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
