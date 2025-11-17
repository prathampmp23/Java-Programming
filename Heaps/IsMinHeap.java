package Heaps;

public class IsMinHeap {
     public boolean isMinHeap(int[] nums) {
        if (nums == null) return false;      // or true depending on spec
        int n = nums.length;
        // All parent nodes are in indices 0..(n/2 - 1)
        for (int i = 0; i <= (n / 2) - 1; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < n && nums[i] > nums[left]) return false;
            if (right < n && nums[i] > nums[right]) return false;
        }
        return true;
    }

    // quick test
    public static void main(String[] args) {
        IsMinHeap s = new IsMinHeap();
        System.out.println(s.isMinHeap(new int[] {1, 3, 2, 7, 6, 4})); // true
        System.out.println(s.isMinHeap(new int[] {2, 1, 3}));          // false
        System.out.println(s.isMinHeap(new int[] {}));                // true
        System.out.println(s.isMinHeap(new int[] {5}));               // true
    }
}
