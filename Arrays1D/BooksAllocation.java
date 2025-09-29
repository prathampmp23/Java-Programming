package Arrays1D;

public class BooksAllocation {

    public static int countStudent(int arr[], int pages) {
        int stu = 1;
        int pageStu = 0;
        for (int i = 0; i < arr.length; i++) {
            if (pageStu + arr[i] <= pages) {
                pageStu += arr[i];
            } else {
                stu++;
                pageStu = arr[i];
            }
        }
        return stu;
    }

    public static int findPages(int[] nums, int m) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudent(nums, mid);
            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int nums[] = { 25, 46, 28, 49, 24 };
        int m = 4;
        System.out.println(findPages(nums, m));
    }
}
