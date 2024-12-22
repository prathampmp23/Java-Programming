import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {

    // Function to get the maximum value in an array
    static int getMax(int[] array, int n) {
        int max = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Function to do counting sort based on a specific digit
    static void countingSort(int[] array, int n, int exp) {
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] contains the actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Copy the output array to array[], so that array[] contains sorted numbers according to current digit
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }

    // Main function to implement Radix Sort
    static void radixSort(int[] array, int n) {
        int max = getMax(array, n);

        // Do counting sort for every digit. Note that exp is 10^i, where i is the current digit number
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, n, exp);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        
        int[] array = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Array before sorting: " + Arrays.toString(array));
        radixSort(array, n);
        System.out.println("Array after sorting: " + Arrays.toString(array));

        scanner.close();
    }
}
