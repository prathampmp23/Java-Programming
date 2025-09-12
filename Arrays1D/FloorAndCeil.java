package Arrays1D;

public class FloorAndCeil {
    public static int[] getFloorAndCeil(int[] arr, int x) {
        // Write your code here.
        int floor = getFloor(arr, x);
        int ceil = getCeil(arr, x);
        return new int[] { floor, ceil };
    }

    static int getFloor(int[] arr, int x) {
        int st = 0, ed = arr.length - 1, ans = -1;
        while (st <= ed) {
            int mid = st + (ed - st) / 2;
            if (arr[mid] <= x) {
                ans = arr[mid];
                st = mid + 1; // move right
            } else {
                ed = mid - 1;
            }
        }
        return ans;
    }

    // Ceil
    static int getCeil(int[] arr, int x) {
        int st = 0, ed = arr.length - 1, ans = -1;
        while (st <= ed) {
            int mid = st + (ed - st) / 2;
            if (arr[mid] >= x) {
                ans = arr[mid];
                ed = mid - 1; // move left
            } else {
                st = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 7, 8, 8, 10 };
        int x = 5;
        int ans[] = getFloorAndCeil(arr, x);
        System.out.println("Floor = "+ans[0]);
        System.out.println("Ceil = "+ans[1]);
        System.out.println(getFloor(arr, x));
        System.out.println(getCeil(arr, x));
    }
}
