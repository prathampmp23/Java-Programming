package Arrays2D;

public class SecondLargeAndSmall {
    public static int secondLargest(int arr[]) {
        int largest = arr[0];
        int secondLarge = -1; // if array dont contain -ve values else +infinity
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLarge = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > secondLarge) {
                secondLarge = arr[i];
            }
        }
        return secondLarge;
    }

    public static int secondSmallest(int arr[]) {
        int smallest = arr[0];
        int secondSmall = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                secondSmall = smallest;
                smallest = arr[i];
            } else if (arr[i] != smallest && arr[i] < secondSmall) {
                secondSmall = arr[i];
            }
        }
        return secondSmall;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 1, 2, 4, 7, 9, 8, -2, -3 };
        System.out.println(secondLargest(arr));
        System.out.println(secondSmallest(arr));
    }
}
