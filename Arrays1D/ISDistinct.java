package Arrays1D;

import java.util.HashSet;

public class IsDistinct {
    public static boolean isDistinct(int num[]) {
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] == num[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // second method using 'HashSet'
    public static boolean containDuplicates(int num[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            if (set.contains(num[i])) {
                return true;
            } else {
                set.add(num[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 1 };
        boolean result = isDistinct(arr);
        if (result) {
            System.out.println("Array has duplicate elements");
        } else {
            System.out.println("Array has distinct elements");
        }
    }
}
