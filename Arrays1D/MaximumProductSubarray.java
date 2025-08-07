package Arrays1D;

public class MaximumProductSubarray {
    // Brute
    public static int maxProduct(int[] nums) {
        int product = 1;
        int maxproduct = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int start = i;
            for (int j = i; j < nums.length; j++) {
                int End = j;
                product = 1;
                for (int k = start; k <= End; k++) {
                    product *= nums[k];
                }
                if (maxproduct < product) {
                    maxproduct = product;
                }
            }
        }
        return maxproduct;
    }

    // Better
    public static int maxProduct2(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }

        return maxProduct;
    }

    // optimal
    public static int maxProduct3(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i < n; i++) {
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;

            prefix *= nums[i]; // 0 to n-1
            suffix *= nums[n - i - 1]; // n-1 to 0
            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, -2, 4 };
        System.out.println(maxProduct(arr));
        System.out.println(maxProduct2(arr));
        System.out.println(maxProduct3(arr));
    }
}
