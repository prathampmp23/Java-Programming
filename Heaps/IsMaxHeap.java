package Heaps;

public class IsMaxHeap {
     public boolean isMinHeap(int[] nums) {
        if (nums == null) return false;      // or true depending on spec
        int n = nums.length;
        // All parent nodes are in indices 0..(n/2 - 1)
        for (int i = 0; i <= (n / 2) - 1; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < n && nums[i] < nums[left]) return false;
            if (right < n && nums[i] < nums[right]) return false;
        }
        return true;
    }

    // quick test
    public static void main(String[] args) {
        IsMaxHeap s = new IsMaxHeap();
        System.out.println(s.isMinHeap(new int[] {30, 21, 23, 10, 20})); // true
        System.out.println(s.isMinHeap(new int[] {10, 20, 30, 21, 23})); // false
        System.out.println(s.isMinHeap(new int[] {-1, -2, -3, -4, -5})); // true
        System.out.println(s.isMinHeap(new int[] {}));                // true
        System.out.println(s.isMinHeap(new int[] {5}));               // true
    }
}
