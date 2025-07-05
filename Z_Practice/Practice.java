package Z_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Practice {

    // ********* Patterns ********* //

    public static void invertStar(int n) {
        System.out.println("Invert Star Pattern");
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }

    public static void halfPyramid(int n) {
        System.out.println("HalfPyramid Pattern");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void charPattern(int n) {
        System.out.println("CharPattern Pattern");
        char ch = 'A';
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
    }

    public static void floydsTriangle(int n) {
        System.out.println("FLOYD'S Triangle Pattern");
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }

    public static void hollowRectangle(int n) {
        System.out.println("HollowRectangle Pattern");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void invertedRotated(int n) {
        System.out.println("InvertedRotatedTriangle Pattern");
        int st = 1;
        int sp = n;
        int lineNo = 1;

        while (lineNo <= n) {
            // print space
            for (int j = 0; j < sp; j++) {
                System.out.print("  ");
            }
            // print star
            for (int k = 0; k < st; k++) {
                System.out.print("* ");
            }
            st++;
            sp--;
            lineNo++;
            System.out.println();
        }
    }

    public static void invertedHalfPyramid(int n) {
        System.out.println("Inverted Half pyramid Pattern");
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void zeroOneTriangle(int n) {
        System.out.println("Zero One Triangle Pattern");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    // if i+j == even
                    System.out.print("1 ");
                } else {
                    // if i+j == odd
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    public static void solidRhombus(int n) {
        System.out.println("Solid Rhombus Pattern");
        int sp = n - 1;
        int lineNo = 1;

        while (lineNo <= n) {
            // print space
            for (int j = 1; j <= sp; j++) {
                System.out.print("  ");
            }
            // print star
            for (int k = 1; k <= n; k++) {
                System.out.print("* ");
            }
            sp--;
            lineNo++;
            System.out.println();
        }
    }

    public static void hollowRhombus(int n) {
        System.out.println("Hollow Rhombus Pattern");
        int sp = n - 1;
        int lineNo = 1;

        while (lineNo <= n) {
            // print space
            for (int j = 1; j <= sp; j++) {
                System.out.print("  ");
            }
            // print star
            for (int k = 1; k <= n; k++) {
                if (lineNo == 1 || lineNo == n || k == 1 || k == n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            sp--;
            lineNo++;
            System.out.println();
        }
    }

    public static void butteryPattern(int n) {
        System.out.println("Butterfly Pattern");
        int st = 1;
        int sp = 2 * n - 2;
        int lineNo = 1;
        while (lineNo <= 2 * n) {
            // print star
            for (int i = 0; i < st; i++) {
                System.out.print("* ");
            }
            // print sapce
            for (int j = 0; j < sp; j++) {
                System.out.print("  ");
            }
            // print star
            for (int i = 0; i < st; i++) {
                System.out.print("* ");
            }
            System.out.println();
            lineNo++;
            if (lineNo <= n) {
                st++;
                sp -= 2;
            } else {
                st--;
                sp += 2;
            }
        }
    }

    // ********* Arrays 1D ********* //

    public static void largeNum(int arr[]) {
        int max = Integer.MIN_VALUE; // -infinity

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("largest num = " + max);
    }

    public static void smallNum(int arr[]) {
        int min = Integer.MAX_VALUE; // -infinity

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("smallest num = " + min);

    }

    public static void binarySearch(int arr[]) {
        int key = 3;
        int si = 0;
        int ei = arr.length - 1;
        int mid = (si + ei) / 2;

        while (si <= ei) {
            if (arr[mid] == key) {
                System.out.println("Key is found at index = " + mid);
                return;
            } else if (arr[mid] > key) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        System.out.println("key is not found");
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void reverseArray(int arr[]) {
        int first = 0;
        int last = arr.length - 1;
        while (first < last) {
            int temp = arr[last];
            arr[last] = arr[first];
            arr[first] = temp;

            first++;
            last--;
        }
        printArray(arr);
    }

    public static void arrayPairs(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + curr + "," + arr[j] + ")");
            }
            System.out.println();
        }
    }

    public static void SubArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            int start = i;
            for (int j = i; j < array.length; j++) {
                int end = j;
                for (int k = start; k <= end; k++) {
                    System.out.print("|" + array[k] + "| ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void subArraySum(int array[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int start = i;
            for (int j = i; j < array.length; j++) {
                int end = j;
                currSum = 0;
                for (int k = start; k <= end; k++) {
                    currSum += array[k];
                }
                // System.out.println(currSum);
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Maximum sum of subarray is: " + maxSum);
    }

    public static void prefixSum(int arr[]) {
        // prfixSumArray = prefix[end] - prefix[start - 1]
        int currSum = 0;
        int maxSum = 0;

        // calculate prefix array
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
                // System.out.println(currSum);
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Maximum sum of subarray is: " + maxSum);
    }

    public static void kadanesAlgo(int arr[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (currSum < 0) {
                currSum = 0;
            }
            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }
        System.out.println("Maximum sum of subarray is: " + maxSum);
    }

    public static void trapedRainWater(int height[]) {
        // calculate left max boundray
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // calculate right max boundray
        int rightMax[] = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // calculate trapedWater = min(leftMax, rightMax) - heightOfBar
        int trapedWater = 0;
        for (int i = 0; i < height.length; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trapedWater += waterLevel - height[i];
        }
        System.out.println("Total Traped water is : " + trapedWater);
    }

    public static void buySellStock(int sellPrice[]) {
        // profit = sellPrice - buyPrice
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE; // This is min price
        for (int i = 0; i < sellPrice.length; i++) {
            // profit condition
            if (buyPrice < sellPrice[i]) {
                int profit = sellPrice[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                // buyPrice is low then buy it
                buyPrice = sellPrice[i];
            }
        }
        System.out.println("Maximum profit = " + maxProfit);
    }

    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        printArray(arr);
    }

    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minPosition]) {
                    minPosition = j;
                }
            }
            // swap
            int temp = arr[i];
            arr[i] = arr[minPosition];
            arr[minPosition] = temp;
        }
        printArray(arr);

    }

    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int previous = i - 1;
            // finding the correct position to insert
            while (previous >= 0 && arr[previous] > curr) {
                arr[previous + 1] = arr[previous];
                previous--;
            }
            // Insertion
            arr[previous + 1] = curr;
        }
        printArray(arr);
    }

    // ********* Arrays 2D ********* //

    public static void spiralMatrix(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // print top
            for (int i = startCol; i <= endCol; i++) {
                System.out.print(matrix[startRow][i] + " ");
            }
            // print right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
            // print bottom
            for (int i = endCol - 1; i >= startCol; i--) {
                if (startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][i] + " ");
            }
            // print left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }

    }

    public static void diagonalSum(int matrix[][]) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            // primary diagonal
            sum += matrix[i][i];
            // secondary diagonal
            if (i != matrix[i][matrix.length - 1 - i]) {
                sum += matrix[i][matrix.length - 1 - i];
            }
        }
        System.out.println("Diagonal sum : " + sum);
    }

    public static void stairCaseSearch(int matrix[][], int key) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("Key is found at index : (" + row + "," + col + ")");
                return;
            } else if (key < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println("Key not found");
    }

    // ********* Strings ********* //

    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void getShortestDistance(String str) {
        int x = 0, y = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'N') {
                y++;
            } else if (str.charAt(i) == 'S') {
                y--;
            } else if (str.charAt(i) == 'E') {
                x++;
            } else {
                x--;
            }
        }
        int X2 = x * x;
        int Y2 = y * y;
        double shortestDistance = Math.sqrt(X2 + Y2);
        System.out.println("shortestDistance = " + shortestDistance);
    }

    public static void pintLargestSubstring(String str[]) {
        String largest = str[0];
        for (int i = 1; i < str.length; i++) {
            if (largest.compareTo(str[i]) < 0) {
                largest = str[i];
            }
        }
        System.out.println("Largest Substring is = " + largest);
    }

    public static void toUpperString(String str) {
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }

    public static void stringCompression(String str) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if (count > 1) {
                sb.append(count.toString());
            }
        }
        System.out.println(sb.toString());
    }

    // ********* Bit manipulation ********* //

    public static void isEven(int n) {
        int bitMass = 1;
        if ((n & bitMass) == 0) {
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }
    }

    public static void getIthBit(int n, int i) {
        int bitMass = 1 << i;
        int getBit = bitMass & n;
        if (getBit == 0) {
            System.out.println("Get ith Bit = " + 0);
        } else {
            System.out.println("Get ith Bit = " + 1);
        }
    }

    public static void clearIthBit(int n, int i) {
        int bitMass = ~(1 << i);
        int getBit = bitMass & n;
        System.out.println("Get ith Bit = " + getBit);
    }

    public static void isPowerof2(int n) {
        int isPower = n & n - 1;
        if (isPower == 0) {
            System.out.println("Is Power of 2");
        } else {
            System.out.println("Is not Power of 2");
        }
    }

    public static void countSetBit(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        System.out.println("Count of setBit = " + count);
    }

    public static void fastExponentiation(int a, int n) {
        // a^n
        int ans = 1;
        while (n > 0) {
            // Check LSB = 1
            if ((n & 1) != 0) {
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        System.out.println("FastExponentiation = " + ans);
    }

    // ********* Recursion ********* //

    public static void printDecrOrder(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        printDecrOrder(n - 1);
    }

    public static void printIncrOrder(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printIncrOrder(n - 1);
        System.out.print(n + " ");
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int fnm1 = factorial(n - 1);
        int fact = n * fnm1;
        return fact;
    }

    public static int sumOfNaturalNo(int n) {
        if (n == 1) {
            return 1;
        }
        int sumnm1 = sumOfNaturalNo(n - 1);
        int sum = n + sumnm1;
        return sum;
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int fibnm1 = fibonacci(n - 1);
        int fibnm2 = fibonacci(n - 2);
        return fibnm1 + fibnm2;
    }

    public static boolean isSorted(int arr[], int idx) {
        if (idx == arr.length - 1) {
            return true;
        }
        if (arr[idx] > arr[idx + 1]) {
            return false;
        }
        return isSorted(arr, idx + 1);
    }

    public static int firstOccurence(int arr[], int idx, int key) {
        if (idx == arr.length - 1) {
            return -1;
        }
        if (arr[idx] == key) {
            return idx;
        }
        return firstOccurence(arr, idx + 1, key);
    }

    public static int lastOccurence(int arr[], int idx, int key) {
        if (idx == arr.length - 1) {
            return -1;
        }
        int isFound = lastOccurence(arr, idx + 1, key);
        if (isFound == -1 && arr[idx] == key) {
            return idx;
        }
        return isFound;
    }

    public static int powerof2(int x, int n) {
        // x^n
        if (n == 0) {
            return 1;
        }
        return x * powerof2(x, n - 1);
    }

    public static int optimizePowerof2(int x, int n) {
        // x^n
        if (n == 0) {
            return 1;
        }
        int halfPower = optimizePowerof2(x, n / 2);
        int halfPowerSquare = halfPower * halfPower;
        // if n is odd
        if (n % 2 != 0) {
            halfPowerSquare = x * halfPowerSquare;
        }
        return halfPowerSquare;
    }

    public static int tilingProblem(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        // for vertical arrangement
        int fnm1 = tilingProblem(n - 1);
        // for horizontal arrangement
        int fnm2 = tilingProblem(n - 2);
        return fnm1 + fnm2;
    }

    public static void removeDuplicates(String str, StringBuilder newStr, int idx, boolean map[]) {
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        // duplicate condition
        if (map[currChar - 'a'] == true) {
            removeDuplicates(str, newStr, idx + 1, map);
        } else {
            // Unique character
            map[currChar - 'a'] = true;
            removeDuplicates(str, newStr.append(currChar), idx + 1, map);
        }
    }

    public static int friendsPairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        // for Single arrangement
        int fnm1 = friendsPairing(n - 1);
        // for pair arrangement
        int fnm2 = (n - 1) * friendsPairing(n - 2);
        return fnm1 + fnm2;
    }

    public static void printBinaryString(int n, String str, int lastDigit) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        printBinaryString(n - 1, str + "0", 0);
        if (lastDigit == 0) {
            printBinaryString(n - 1, str + "1", 1);
        }
    }

    // ********* Divide and concquer ********* //

    public static void mergeSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // For Remaining part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // Copy temp arr to original
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void printaray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        // Pivot is last element
        int pivotIdx = partition(arr, si, ei);
        // left part
        quickSort(arr, si, pivotIdx - 1);
        // right part
        quickSort(arr, pivotIdx + 1, ei);
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = arr[ei];
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static int sortedAndRotatedSearch(int arr[], int si, int ei, int key) {
        if (si > ei) {
            return -1;
        }
        int mid = si + (ei - si) / 2;
        if (arr[mid] == key) {
            return mid;
        }

        // mid on line 1
        if (arr[si] <= arr[mid]) {
            // case 1 - left part
            if (arr[si] <= key && key <= arr[mid]) {
                return sortedAndRotatedSearch(arr, si, mid - 1, key);
            } else {
                // case 2 right part
                return sortedAndRotatedSearch(arr, mid + 1, ei, key);
            }
        }
        // mid on line 1
        else {
            // case 3 - right part
            if (arr[mid] <= key && key <= arr[ei]) {
                return sortedAndRotatedSearch(arr, mid + 1, ei, key);
            } else {
                // case 4 left part
                return sortedAndRotatedSearch(arr, si, mid - 1, key);
            }
        }
    }

    // ********* BackTracking ********* //

    public static void changeArray(int arr[], int val, int idx) {
        if (idx == arr.length) {
            printArray(arr);
            return;
        }
        // assign value
        arr[idx] = val;
        // recursive call
        changeArray(arr, val + 1, idx + 1);
        // backtracking
        arr[idx] = arr[idx] - 2;
    }

    public static void stringSubSet(String str, String newStr, int idx) {
        if (idx == str.length()) {
            if (newStr.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(newStr);
            }
            return;
        }
        // yes choice
        stringSubSet(str, newStr + str.charAt(idx), idx + 1);
        // no choice
        stringSubSet(str, newStr, idx + 1);
    }

    public static void permutation(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            permutation(newStr, ans + currChar);
        }
    }

    public static void printBoard(char board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void nQueens(char board[][], int row) {
        if (row == board.length) {
            printBoard(board);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            // check is safe place to place Queen
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
                nQueens(board, row + 1);
                board[row][i] = '.';
            }
        }
    }

    public static boolean isSafe(char board[][], int row, int col) {
        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static int gridWays(int i, int j, int m, int n) {
        // condition for last cell (Base Case)
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        // boundary cross condition
        else if (i == m || j == n) {
            return 0;
        }
        // down move
        int w1 = gridWays(i + 1, j, m, n);
        // right move
        int w2 = gridWays(i, j + 1, m, n);
        return w1 + w2;
    }

    public static void printSudoku(int sudoku[][]) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        if (row == 9) {
            return true;
        }
        int nextrow = row, nextcol = col + 1;
        if (col + 1 == 9) {
            nextrow = row + 1;
            nextcol = 0;
        }
        // condition for already set element
        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextrow, nextcol);
        }
        // now add correct digit
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafed(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, nextrow, nextcol)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean isSafed(int sudoku[][], int row, int col, int digit) {
        // check for column
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[row][i] == digit) {
                return false;
            }
        }
        // check for row
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[row][i] == digit) {
                return false;
            }
        }
        // check for grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    // ********* ArrayList ********* //

    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2)); // list.set(index , location)
        list.set(idx2, temp);
    }

    public static void containerWithMostWater(ArrayList<Integer> height) {
        // Brute Force
        int maxWater = 0;
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int wd = j - i;
                int currentWater = ht * wd;
                maxWater = Math.max(maxWater, currentWater);
            }
        }
        System.out.println(maxWater);
    }

    public static void containerWithMostWater2(ArrayList<Integer> height) {
        // 2 pointer Approach
        int maxWater = 0;
        int Lp = 0;
        int Rp = height.size() - 1;
        while (Lp < Rp) {
            int ht = Math.min(height.get(Lp), height.get(Rp));
            int wd = Rp - Lp;
            int currentWater = ht * wd;
            if (Lp < Rp) {
                Lp++;
            } else {
                Rp--;
            }
            maxWater = Math.max(maxWater, currentWater);
        }
        System.out.println(maxWater);
    }

    public static void pairSum(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == target) {
                    System.out.println(list.get(i) + "," + list.get(j));
                }
            }
        }
    }

    public static void pairSum2(ArrayList<Integer> list, int target) {
        int Lp = 0;
        int Rp = list.size() - 1;
        while (Lp != Rp) {
            if (list.get(Lp) + list.get(Rp) == target) {
                System.out.println(list.get(Lp) + "," + list.get(Rp));
            }
            if (list.get(Lp) + list.get(Rp) < target) {
                Lp++;
            } else {
                Rp--;
            }
        }
    }

    public static void pairSumOfSortedAndRotated(ArrayList<Integer> list, int target) {
        /*
         * In this we use Modular Arithmatic that is for Sorted & Rotated array
         * Its increment condition is change from lp++ or rp-- to
         * leftPointer (lp) = (lp+1) % n
         * rightpointer (rp) = (n+rp-1) % n
         */
        int pivot = -1;
        int n = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(i + 1)) {
                pivot = i;
                break;
            }
        }
        int Lp = pivot + 1; // Smallest
        int Rp = pivot;
        while (Lp != Rp) {
            if (list.get(Lp) + list.get(Rp) == target) {
                System.out.println(list.get(Lp) + "," + list.get(Rp));
            }
            if (list.get(Lp) + list.get(Rp) < target) {
                Lp = (Lp + 1) % n;
            } else {
                Rp = (n + Rp - 1) % n;
            }
        }
    }

    // ********* LinkedList ********* //

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public static void addFirst(int data) {
        // create newNode
        Node newNode = new Node(data);

        // if LinkedList is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // point newNode next --> head
        newNode.next = head;

        // make head points to newNode
        head = newNode;

        size++;
    }

    public static void addLast(int data) {
        // create newNode
        Node newNode = new Node(data);

        // if LinkedList is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // point tail next --> newNode
        tail.next = newNode;

        // make tail points to newNode
        tail = newNode;

        size++;
    }

    public static void printLinkedList() {
        if (head == null) {
            System.out.println("L is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("->null");
    }

    public static void addAtMid(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newnode = new Node(data);
        Node temp = head;
        int i = 0;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        // i = idx-1;
        // temp -> previous
        newnode.next = temp.next;
        temp.next = newnode;

        size++;
    }

    public static int removeFirst() {
        if (size == 0) {
            System.out.println("L is empty!");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int value = head.data;
            head = tail = null;
            size = 0;
            return value;
        }
        int value = head.data;
        head = head.next;
        size--;
        return value;
    }

    public static int removeLast() {
        if (size == 0) {
            System.out.println("Linkedlist is empty!");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int value = head.data;
            head = tail = null;
            size = 0;
            return value;
        }

        Node previous = head;
        for (int i = 0; i < size - 2; i++) {
            previous = previous.next;
        }

        int value = previous.next.data;
        previous.next = null;
        tail = previous;
        size--;
        return value;
    }

    public static int iterativeSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            // key found
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public static int recursiveSearch(int key) {
        return helperFunc(head, key);
    }

    public static int helperFunc(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        // Recursion
        int idx = helperFunc(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public static void reverse() {
        // To reverse a linkedlist there are
        // ** 3 variables
        // ** 4 step in loop

        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void delNthFromEnd(int n) {
        // calculate size
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        // if n = sz -> head
        if (n == sz) {
            head = head.next;
            return;
        }

        // sz - n
        int i = 1;
        int itoFind = sz - n;
        Node prev = head;
        while (i < itoFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public static Node findMid(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        // find midNode using slow-Fast approach
        Node midNode = findMid(head);

        // Reverse
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Compare
        Node left = head;
        Node right = prev;

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static boolean isCycle() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // if cycle exist
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle() {
        // detect cycle
        Node fast = head;
        Node slow = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // if cycle exist
            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        // If no cycle detected
        if (cycle == false) {
            return;
        }

        // Find meeting point
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast; // to get previous node before they meet
            fast = fast.next;
            slow = slow.next;
        }

        // Remove Cycle
        prev.next = null;
    }

    public static Node findLLMid(Node head) {
        Node fast = head.next;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Node mergeLL(Node head1, Node head2) {
        Node mergeList = new Node(-1);

        Node temp = mergeList;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergeList.next;
    }

    public static Node mergeSortLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // find mid
        Node midNode = findLLMid(head);

        // make 2 seperate list by making mid points to null
        Node rightHead = midNode.next;
        midNode.next = null;

        // left part
        Node newLeft = mergeSortLL(head);
        // right part
        Node newRight = mergeSortLL(rightHead);

        // merge list
        return mergeLL(newLeft, newRight);
    }

    public static void zigZag() {
        // Find mid
        Node fast = head.next;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node mid = slow;

        // Reverse 2 half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Alternate merging (Zigzag merge)
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }

    // ********* Stack ********* //

    // Stack using ArrayList
    public static class STACK {
        static ArrayList<Integer> list = new ArrayList<>();

        // isEmpty()
        public static boolean isEmpty() {
            return list.size() == 0;
        }

        // PUSH
        public static void push(int data) {
            list.add(data);
        }

        // POP
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // Peek
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    // Stack using linkedList
    public static class STACK2 {
        static Node head = null;

        // isEmpty()
        public static boolean isEmpty() {
            return head == null;
        }

        // PUSH
        public static void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        // POP
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        // Peek
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            // push at botttom
            s.push(data);
            return;
        }
        int top = s.pop();
        // recursion
        pushAtBottom(s, data);
        s.push(top);
    }

    public static String reverseStringUsingStack(String str) {
        Stack<Character> s = new Stack<>();

        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder newStr = new StringBuilder("");
        while (!s.isEmpty()) {
            char ch = s.pop();
            newStr.append(ch);
        }
        return newStr.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        while (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s); // recursion
        pushAtBottom(s, top); // call insert at bottom
    }

    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();

        span[0] = 1; // it always 1 as there is no element to compare
        s.push(0);

        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            // check if stack is not empty and the index value in stack is smaller than
            // currPrice then pop
            while (!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }
            // if stack is empty then it is the largest one
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }

    public static void nextGreaterRight(int arr[]) {
        // Brute force
        int newArr[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = i + 1; j < newArr.length; j++) {
                if (arr[i] < arr[j]) {
                    newArr[i] = arr[j];
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                newArr[i] = -1;
            }
        }
        printArray(newArr);
    }

    public static void nextGreaterRight2(int arr[]) {
        // using stack
        Stack<Integer> s = new Stack<>();
        int nextRightGreater[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            // if value at stack top is smaller than element then pop
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            // if no greater element is present then return -1
            if (s.isEmpty()) {
                nextRightGreater[i] = -1;
            } else {
                // if greater exist then it is present at top
                nextRightGreater[i] = arr[s.peek()];
            }
            // push (element) idex
            s.push(i);
        }
        printArray(nextRightGreater);
    }

    public static void nextGreaterLeft(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int nextRightGreater[] = new int[arr.length];

        for (int i = 0; i < arr.length - 1; i++) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nextRightGreater[i] = -1;
            } else {
                nextRightGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
        printArray(nextRightGreater);
    }

    public static boolean isValidParenteses(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // opening bracket (push)
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            }

            // closing brackets (if match then pop)
            else {
                // if stack is empty
                if (s.isEmpty()) {
                    return false;
                }

                // check if pair exist (stack top (Opening brackets) == ch (Closing brackets))
                if ((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}')
                        || (s.peek() == '[' && ch == ']')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }

        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDuplicateParentheses(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // if closing (pop)
            if (ch == ')') {
                int count = 0; // count items (operator and operand)

                // Till it didnt find opening pair count ++
                while (s.pop() != '(') {
                    count++; // if expression is present then count ++
                }
                // if no operands or operators is present between parentheses then it is
                // duplicate
                // if expression is not present then count = 0
                if (count < 1) {
                    return true; // duplicates
                }
            } else {
                // if opening, operator and operand then (push)
                s.push(ch);
            }
        }
        return false;
    }

    public static void maxAreaOfHistogram(int arr[]) {
        int maxarea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        // next smaller right
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        // next smaller left
        s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        // current area : width = j-i-1 = nsr[i] - nsl[i] -1
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxarea = Math.max(maxarea, currArea);
        }

        System.out.println("Maximum area in histogram = " + maxarea);
    }

    // ********* Queue ********* //

    static class Queue1 {
        static int arr[];
        static int size;
        static int rear;

        Queue1(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        // is empty
        public static boolean isEmpty() {
            return rear == -1;
        }

        // add
        public static void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full!");
                return;
            }
            rear = rear + 1;
            arr[rear] = data;
        }

        // remove
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty!");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear = rear - 1;
            return front;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty!");
                return -1;
            }
            return arr[0];
        }
    }

    static class CircularQueue {
        static int arr[];
        static int size;
        static int front;
        static int rear;

        CircularQueue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        // is empty
        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        // is full
        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        // add
        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full!");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // remove
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty!");
                return -1;
            }
            int result = arr[front];
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty!");
                return -1;
            }
            return arr[front];
        }
    }

    static class QueueUsingLinkedList {
        static Node head;
        static Node tail;

        // is empty
        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        // add
        public static void add(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = tail = newNode;
            }
            // add node to rear end (tail)
            tail.next = newNode;
            tail = newNode;
        }

        // remove
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty!");
                return -1;
            }
            int front = head.data;
            // if single node
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }
            return front;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty!");
                return -1;
            }
            return head.data;
        }
    }

    static class QueueUsing2Stack {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // Add - O(n)
        public static void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // Remove - O(1)
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.pop();
        }

        // Peek - O(1)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.peek();
        }
    }

    static class StackUsing2Queue {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void add(int data) {
            // add data inside queue which is empty
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            int top = -1;

            // case 1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (!q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            } else { // case 2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (!q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            int top = -1;

            // case 1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else { // case 2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }

    public static void firstNonRepeatingNo(String str) {
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            // if freq > 1 remove element from queue as it is repeating
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }

    public static void interleaveTwoHalfOFQueue(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();

        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(q.remove());
        }

        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    public static void queueReversal(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();

        while (!q.isEmpty()) {
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    // ********* Greedy Algorithm ********* //

    public static void activitySelection(int start[], int end[]) {
        // If Activities are sorted according to end time is mention

        // End time basis sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st Activity
        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];

        for (int i = 1; i < end.length; i++) {
            // if end time is smaller or equal to new start time then select it
            // (Non overlaping condition)
            if (start[i] >= lastEnd) {
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }
        System.out.println("Max Activities = " + maxAct);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
    }

    public static void activitySelection2(int start[], int end[]) {
        // ## If Activities (start,end) are sorted 'not' mention

        // Sorting
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i; // index
            activities[i][1] = start[i]; // start time
            activities[i][2] = end[i]; // end time
        }

        // "Lambda function" -> shortForm functions

        // In Java, Comparator is an interface for sorting Java Objects.
        // A Comparator that defines how the elements should be compared.
        // The lambda function o -> o[2] extracts the third element (o[2]) from each
        // sub-array (which represents the end time of an activity). It acts as the
        // sorting key.
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2])); // sorted end time

        // End time basis sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st Activity
        maxAct = 1;
        ans.add(activities[0][0]); // index
        int lastEnd = activities[0][2]; // end time

        for (int i = 1; i < end.length; i++) {
            // if end time is smaller or equal to new start time then select it
            // (Non overlaping condition)

            // start time >= end time
            if (activities[i][1] >= lastEnd) {
                maxAct++;
                ans.add(activities[i][0]); // index
                lastEnd = activities[i][2]; // end time
            }
        }
        System.out.println("Max Activities = " + maxAct);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
    }

    public static void fractionalKnapsack(int value[], int weight[], int w) {
        double ratio[][] = new double[value.length][2];

        for (int i = 0; i < ratio.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double) weight[i];
        }

        // sort it in ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int finalValue = 0;
        int capacity = w;

        // we calculate finalvalue from decreasing order of ratio
        for (int i = ratio.length - 1; i >= 0; i--) {
            // ratio index
            int idx = (int) ratio[i][0];

            // full weight is included
            if (capacity >= weight[idx]) {
                finalValue += value[idx];
                capacity -= weight[idx];
            } else {
                // part of weight included
                finalValue += ratio[i][1] * capacity;
                capacity = 0;
                break;
            }
        }

        System.out.println("Maximum total value from Knapsack = " + finalValue);
    }

    public static void minAbsoluteDiff(int A[], int B[]) {
        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;
        for (int i = 0; i < A.length; i++) {
            minDiff += Math.abs(A[i] - B[i]);
        }
        System.out.println("Min Absolute difference = " + minDiff);
    }

    public static void maxChainPair(int pair[][]) {
        // sort pair
        Arrays.sort(pair, Comparator.comparingDouble(o -> o[1]));

        int chainLength = 1;
        int chainEnd = pair[0][1]; // last selected end pair (1st pair)

        for (int i = 1; i < pair.length; i++) {
            if (pair[i][0] > chainEnd) {
                chainLength++;
                chainEnd = pair[i][1];
            }
        }
        System.out.println("Max length of chain = " + chainLength);
    }

    public static void indianCoin(Integer coin[], int amount) {
        // sort it in descending order
        Arrays.sort(coin, Comparator.reverseOrder());
        int countCoins = 0;

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < coin.length; i++) {
            // if (coin[i] <= amount) {
            while (coin[i] <= amount) {
                countCoins++;
                ans.add(coin[i]);
                amount -= coin[i];
            }
            // }
        }
        System.out.println("Total min coins used = " + countCoins);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    static class Job {
        int profit;
        int deadline;
        int id;

        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void jobSequencing(int jobInfo[][]) {
        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        // sort object in descending order of profit
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        ArrayList<Integer> ans = new ArrayList<>();

        int time = 0;

        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                ans.add(curr.id);
                time++;
            }
        }
        System.out.println("Max jobs = " + ans.size());
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }

    public static void chocolaProblem() {
        Integer horizontalCost[] = { 2, 1, 3, 1, 4 }; // m-1
        Integer verticalCost[] = { 4, 1, 2 }; // n-1

        Arrays.sort(horizontalCost, Collections.reverseOrder());
        Arrays.sort(verticalCost, Collections.reverseOrder());

        int hCut = 0, vCut = 0;
        int hPiece = 1, vPiece = 1;
        int cost = 0;

        while (hCut < horizontalCost.length && vCut < verticalCost.length) {
            if (horizontalCost[hCut] >= verticalCost[vCut]) {
                cost += horizontalCost[hCut] * vPiece;
                hPiece++;
                hCut++;
            } else {
                cost += verticalCost[vCut] * hPiece;
                vPiece++;
                vCut++;
            }
        }
        while (hCut < horizontalCost.length) {
            cost += horizontalCost[hCut] * vPiece;
            hPiece++;
            hCut++;
        }
        while (vCut < verticalCost.length) {
            cost += verticalCost[vCut] * hPiece;
            vPiece++;
            vCut++;
        }
        System.out.println("Min cost of cuts = " + cost);
    }

    // ********* Binary Trees ********* //

    static class Node1 {
        int data;
        Node1 right;
        Node1 left;

        Node1(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    static class BinaryTree {

        // Build Binary tree
        static int idx = -1;

        public static Node1 buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node1 newNode = new Node1(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        // PreOrder traversal
        public static void preOrder(Node1 root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        // InOrder traversal
        public static void inOrder(Node1 root) {
            if (root == null) {
                return;
            }
            preOrder(root.left);
            System.out.print(root.data + " ");
            preOrder(root.right);
        }

        // PostOrder traversal
        public static void postOrder(Node1 root) {
            if (root == null) {
                return;
            }
            preOrder(root.left);
            preOrder(root.right);
            System.out.print(root.data + " ");
        }

        // Level Order Traversal
        public static void levelOrder(Node1 root) {
            if (root == null) {
                return;
            }
            int level = 1;
            Queue<Node1> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node1 currnode = q.remove();
                if (currnode == null) {
                    System.out.println("<-- Level = " + level);
                    level++;
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currnode.data + " ");
                    if (currnode.left != null) {
                        q.add(currnode.left);
                    }
                    if (currnode.right != null) {
                        q.add(currnode.right);
                    }
                }
            }
        }

        // height of Binary Tree
        public static int heightOfBT(Node1 root) {
            if (root == null) {
                return 0;
            }
            int LH = heightOfBT(root.left);
            int RH = heightOfBT(root.right);
            return Math.max(LH, RH) + 1;
        }

        // Count of nodes
        public static int countNode(Node1 root) {
            if (root == null) {
                return 0;
            }
            int LCount = countNode(root.left);
            int RCount = countNode(root.right);
            return LCount + RCount + 1;
        }

        // Sum of nodes
        public static int sumOfNode(Node1 root) {
            if (root == null) {
                return 0;
            }
            int LSum = sumOfNode(root.left);
            int RSum = sumOfNode(root.right);
            return LSum + RSum + root.data;
        }

        // diameter of tree
        // Approach - I
        public static int diameter(Node1 root) {
            if (root == null) {
                return 0;
            }
            int LDiameter = diameter(root.left);
            int RDiameter = diameter(root.right);
            int LH = heightOfBT(root.left);
            int RH = heightOfBT(root.right);

            int selfDiameter = LH + RH + 1;
            return Math.max(selfDiameter, Math.max(RDiameter, LDiameter));
        }

        // Approach - I
        static class Info {
            int diameter;
            int ht;

            Info(int diameter, int ht) {
                this.diameter = diameter;
                this.ht = ht;
            }
        }

        public static Info diameter2(Node1 root) {
            if (root == null) {
                return new Info(0, 0);
            }
            Info LInfo = diameter2(root.left);
            Info RInfo = diameter2(root.right);

            int dia = Math.max(Math.max(LInfo.diameter, RInfo.diameter), LInfo.ht + RInfo.ht + 1);
            int ht = Math.max(LInfo.ht, RInfo.ht) + 1;
            return new Info(dia, ht);
        }

        public static boolean isIdentical(Node1 root, Node1 subRoot) {
            if (root == null && subRoot == null) {
                return true;
            } else if (root == null || subRoot == null || root.data != subRoot.data) {
                return false;
            }

            if (!isIdentical(root.left, subRoot.left)) {
                return false;
            }
            if (!isIdentical(root.right, subRoot.right)) {
                return false;
            }
            return true;
        }

        public static boolean isSubtree(Node1 root, Node1 subRoot) {
            if (root == null) {
                return false;
            }
            if (root.data == subRoot.data) {
                if (isIdentical(root, subRoot)) {
                    return true;
                }
            }
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        static class MapInfo {
            Node1 node;
            int hd;

            MapInfo(Node1 node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        public static void topView(Node1 root) {
            // level order traversal
            Queue<MapInfo> q = new LinkedList<>();
            HashMap<Integer, Node1> map = new HashMap<>();

            int max = 0, min = 0;
            q.add(new MapInfo(root, 0));
            q.add(null);

            // run till queue is not empty
            while (!q.isEmpty()) {
                // find current from queue
                MapInfo curr = q.remove();
                if (curr == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    // check is hd is present in map before
                    if (!map.containsKey(curr.hd)) {
                        // if not then put it in map
                        map.put(curr.hd, curr.node);
                    }

                    // check for left child
                    if (curr.node.left != null) {
                        q.add(new MapInfo(curr.node.left, curr.hd - 1));
                        min = Math.min(min, curr.hd - 1);
                    }
                    // check for right child
                    if (curr.node.right != null) {
                        q.add(new MapInfo(curr.node.right, curr.hd + 1));
                        max = Math.max(min, curr.hd + 1);
                    }
                }
            }

            // print top view
            for (int i = min; i <= max; i++) {
                System.out.print(map.get(i).data + " ");
            }
        }

        public static void kthLevel(Node1 root, int k) {
            if (root == null) {
                return;
            }
            int level = 1;
            Queue<Node1> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node1 currnode = q.remove();
                if (currnode == null) {
                    level++;
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    if (level == k) {
                        System.out.print(currnode.data + " ");
                    }
                    if (currnode.left != null) {
                        q.add(currnode.left);
                    }
                    if (currnode.right != null) {
                        q.add(currnode.right);
                    }
                }
            }
        }

        public static void kthLevel2(Node1 root, int level, int k) {
            if (root == null) {
                return;
            }
            if (level == k) {
                System.out.print(root.data + " ");
                return;
            }
            kthLevel2(root.left, level + 1, k);
            kthLevel2(root.right, level + 1, k);
        }

        // LCA Approach 1
        public static boolean getPath(Node1 root, int n, ArrayList<Node1> path) {
            if (root == null) {
                return false;
            }

            // add path
            path.add(root);

            // if data found
            if (root.data == n) {
                return true;
            }

            // else find data in
            boolean foundLeft = getPath(root.left, n, path); // left subtree
            boolean foundRight = getPath(root.right, n, path); // right subtree

            // if exist in any one of subtrees
            if (foundLeft || foundRight) {
                return true;
            }

            // current node is not a part of path
            path.remove(path.size() - 1);
            return false;
        }

        // T.c = O(n)
        public static Node1 lca(Node1 root, int n1, int n2) {
            ArrayList<Node1> path1 = new ArrayList<>();
            ArrayList<Node1> path2 = new ArrayList<>();

            // get path from root to n1
            getPath(root, n1, path1);
            // get path from root to n2
            getPath(root, n2, path2);

            // Last common Ancestor
            int i = 0;
            for (; i < path1.size() && i < path2.size(); i++) {
                // when they are unequal in terms of values
                if (path1.get(i) != path2.get(i)) {
                    break;
                }
            }

            // last equal node value -> i - 1th
            Node1 lca = path1.get(i - 1);
            return lca;
        }

        // LCA Approach 2
        public static Node1 lca2(Node1 root, int n1, int n2) {
            if (root == null || root.data == n1 || root.data == n2) {
                return root;
            }

            Node1 leftLCA = lca2(root.left, n1, n2);
            Node1 rightLCA = lca2(root.right, n1, n2);

            // leftLCA -> return some value & rightLCA return null
            if (rightLCA == null) {
                return leftLCA;
            }
            if (leftLCA == null) {
                return rightLCA;
            }
            return root;
        }

        public static int minDistance(Node1 root, int n1, int n2) {
            Node1 LCA = lca2(root, n1, n2);

            int dist1 = localDist(LCA, n1);
            int dist2 = localDist(LCA, n2);

            return dist1 + dist2;
        }

        public static int localDist(Node1 root, int n) {
            if (root == null) {
                return -1;
            }

            if (root.data == n) {
                return 0;
            }
            int leftDist = localDist(root.left, n);
            int rightDist = localDist(root.right, n);

            if (leftDist == -1 && rightDist == -1) {
                return -1;
            } else if (leftDist == -1) {
                return rightDist + 1;
            } else {
                return leftDist + 1;
            }
        }

        public static int kthAncestor(Node1 root, int n, int k) {
            if (root == null) {
                return -1;
            }
            if (root.data == n) {
                return 0;
            }
            int leftDist = kthAncestor(root.left, n, k);
            int rightDist = kthAncestor(root.right, n, k);

            if (leftDist == -1 && rightDist == -1) {
                return -1;
            }

            int max = Math.max(leftDist, rightDist);
            if (max + 1 == k) {
                System.out.println(root.data); // kth ancestor
            }
            return max + 1;
        }

        public static int transform(Node1 root) {
            if (root == null) {
                return 0;
            }
            int LChild = transform(root.left);
            int RChild = transform(root.right);

            // original node data
            int data = root.data;

            int newLeft = root.left == null ? 0 : root.left.data;
            int newRight = root.right == null ? 0 : root.right.data;

            // change root.data to new updated sum value
            root.data = newLeft + LChild + newRight + RChild;

            // return original node for calculating left and right child
            return data;
        }
    }

    // ********* Binary Search Trees ********* //

    static class Node2 {
        int data;
        Node2 left, right;

        Node2(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Inorder
    public static void inorder(Node2 root) { // O(n)
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // preorder
    public static void preorder(Node2 root) { // O(n)
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node2 insert(Node2 root, int value) {
        if (root == null) {
            root = new Node2(value);
            return root;
        }

        if (root.data > value) {
            // left Subtree
            root.left = insert(root.left, value);
        } else {
            // right Subtree
            root.right = insert(root.right, value);
        }
        return root;
    }

    public static boolean searchInBST(Node2 root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (root.data > key) {
            return searchInBST(root.left, key);
        } else {
            return searchInBST(root.right, key);
        }
    }

    public static Node2 deleteNode(Node2 root, int value) {
        if (root.data > value) {
            root.left = deleteNode(root.left, value);
        } else if (root.data < value) {
            root.right = deleteNode(root.right, value);
        } else {
            // Case 1 - leaf node(no child)
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2 - Single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3 - Two childrens
            Node2 inorderSuccessorNode = findInorderSuccessor(root.right);
            root.data = inorderSuccessorNode.data;
            root.right = deleteNode(root.right, inorderSuccessorNode.data);
        }
        return root;
    }

    public static Node2 findInorderSuccessor(Node2 root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRangeNode(Node2 root, int k1, int k2) {
        if (root == null) {
            return;
        }
        // if range data lies in both left and right subtree
        // k1 <= root <= k2
        if (root.data >= k1 && root.data <= k2) {
            printInRangeNode(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRangeNode(root.right, k1, k2);
        }
        // root > k1 (if all range data lies in left subTree)
        else if (root.data > k1) {
            printInRangeNode(root.left, k1, k2);
        }
        // root < k2 (if all range data lies in right subTree)
        else {
            printInRangeNode(root.right, k1, k2);
        }
    }

    public static void printarrayList(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

    public static void rootToLeafPath(Node2 root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        // condition for leaf node
        if (root.left == null && root.right == null) {
            printarrayList(path);
        }
        rootToLeafPath(root.left, path);
        rootToLeafPath(root.right, path);
        path.remove(path.size() - 1);
    }

    public static boolean isValidBST(Node2 root, Node2 max, Node2 min) {
        if (root == null) {
            return true;
        }

        if (min != null && root.data <= min.data) {
            return false;
        }
        if (max != null && root.data >= max.data) {
            return false;
        }
        // check for its subtree
        return isValidBST(root.left, root, min) && isValidBST(root.right, max, root);
    }

    public static Node2 mirrorBST(Node2 root) {
        if (root == null) {
            return null;
        }

        Node2 leftMirror = mirrorBST(root.left);
        Node2 rightMirror = mirrorBST(root.right);

        // pointing to mirror subtree or left to right and right to left
        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    public static Node2 createBalancedBST(int arr[], int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node2 root = new Node2(arr[mid]);

        root.left = createBalancedBST(arr, start, mid - 1);
        root.right = createBalancedBST(arr, mid + 1, end);

        return root;
    }

    public static void getInorderSeq(Node2 root, ArrayList<Integer> sequence) {
        if (root == null) {
            return;
        }
        getInorderSeq(root.left, sequence);
        sequence.add(root.data);
        getInorderSeq(root.right, sequence);
    }

    public static Node2 createBalancedBST2(ArrayList<Integer> sequence, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node2 root = new Node2(sequence.get(mid));

        root.left = createBalancedBST2(sequence, start, mid - 1);
        root.right = createBalancedBST2(sequence, mid + 1, end);

        return root;
    }

    public static Node2 BSTtoBalancedBST(Node2 root) {
        // get inorder sequence
        ArrayList<Integer> sequence = new ArrayList<>();
        getInorderSeq(root, sequence);

        // inorder to banlanceBST
        root = createBalancedBST2(sequence, 0, sequence.size() - 1);
        return root;
    }

    static class Info2 {
        boolean isBST;
        int size;
        int max;
        int min;

        Info2(boolean isBST, int size, int max, int min) {
            this.isBST = isBST;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }

    public static int maxBST = 0;

    public static Info2 largestBST(Node2 root) {
        if (root == null) {
            return new Info2(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        // store information of left and right recursively
        Info2 leftInfo = largestBST(root.left);
        Info2 rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;

        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));

        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info2(false, size, max, min);
        }

        if (leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info2(true, size, max, min);
        }
        return new Info2(false, size, max, min);
    }

    public static Node2 merge2BST(Node2 root1, Node2 root2) {
         // Get Inorder sequence
        // BST1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorderSeq(root1, arr1);

        // BST2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorderSeq(root2, arr2);

        // Merge BST1 and BST2
        int i = 0, j = 0;
        ArrayList<Integer> finalList = new ArrayList<>();

        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                finalList.add(arr1.get(i));
                i++;
            } else {
                finalList.add(arr2.get(j));
                j++;
            }
        }

        // for remaining 
        while (i < arr1.size()) {
            finalList.add(arr1.get(i));
            i++;
        }

        while (j < arr1.size()) {
            finalList.add(arr2.get(j));
            j++;
        }

        // Sorted arrayList -> Balanced BST
        return createBalancedBST2(finalList, 0, finalList.size() - 1);
    }

    
    public static void main(String args[]) {

        System.out.println("*** Pattern Codes ***");
        int n = 4;
        butteryPattern(n);

        System.out.println("*** Arrays 1D ***");

        int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        kadanesAlgo(arr);

        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        trapedRainWater(height);

        int price[] = { 7, 1, 5, 3, 6, 4, };
        buySellStock(price);

        System.out.println("*** Sorting Algorithm ***");

        int sortArray[] = { 6, 5, 4, 3, 2, 1 };
        insertionSort(sortArray);

        System.out.println("*** Arrays 2D ***");

        int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        spiralMatrix(matrix);
        System.out.println();
        diagonalSum(matrix);

        int StaircaseMatrix[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };
        stairCaseSearch(StaircaseMatrix, 32);

        String str = "aabbaa";
        System.out.println(isPalindrome(str));

        String direction = "WNEENESENNN";
        getShortestDistance(direction);

        String strs[] = { "apple", "banana", "mango" };
        pintLargestSubstring(strs);

        String msg = "hi my name is pratham";
        toUpperString(msg);

        String str2 = "aaabbccdd";
        stringCompression(str2);

        System.out.println("*** Bit Manipulation ***");
        isEven(5);
        getIthBit(5, 1);
        clearIthBit(5, 0);
        isPowerof2(4);
        countSetBit(5);
        fastExponentiation(3, 5);

        System.out.println("*** Recursion ***");
        printIncrOrder(10);
        System.out.println();
        printDecrOrder(10);
        System.out.println();
        System.out.println(factorial(5));
        System.out.println(sumOfNaturalNo(5));
        System.out.println(fibonacci(5));
        int sortarr[] = { 1, 2, 3, 4, 5 };
        System.out.println(isSorted(sortarr, 0));
        System.out.println(firstOccurence(height, 0, 2));
        System.out.println(lastOccurence(height, 0, 2));
        System.out.println(powerof2(2, 5));
        System.out.println(optimizePowerof2(2, 5));
        System.out.println(tilingProblem(3));
        String duplicateStr = "apnacollage";
        removeDuplicates(duplicateStr, new StringBuilder(""), 0, new boolean[26]);
        System.out.println(friendsPairing(3));
        printBinaryString(4, "", 0);

        System.out.println("*** Divide and conquer ***");
        mergeSort(sortArray, 0, sortArray.length - 1);
        printArray(sortArray);
        quickSort(sortArray, 0, sortArray.length - 1);
        printArray(sortArray);
        int sortedRotatedArr[] = { 4, 5, 6, 7, 0, 1, 2, 3 };
        System.out.println(sortedAndRotatedSearch(sortedRotatedArr, 0, sortedRotatedArr.length - 1, 0));

        System.out.println("*** Backtracking ***");
        changeArray(sortedRotatedArr, 1, 0);
        // array after backtracking
        printArray(sortedRotatedArr);
        stringSubSet("abc", "", 0);
        permutation("abc", "");

        char board[][] = new char[4][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        nQueens(board, 0);

        System.out.println(gridWays(0, 0, 3, 3));

        int sudoku[][] = { { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 } };
        if (sudokuSolver(sudoku, 0, 0)) {
            System.out.println("Solution is Exists");
            printSudoku(sudoku);
        } else {
            System.out.println("Solution is not Exists");
        }

        System.out.println("*** ArrayList ***");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list.get(1));

        // int idx1 = 1, idx2 = 3;
        // System.out.println(list);
        // swap(list, idx1, idx2);
        // System.out.println(list);

        // Multi Dimensional ArrayList
        ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        mainlist.add(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        mainlist.add(list2);

        for (int i = 0; i < mainlist.size(); i++) {
            ArrayList<Integer> current = mainlist.get(i);
            for (int j = 0; j < current.size(); j++) {
                System.out.print(current.get(j) + " ");
            }
            System.out.println();
        }

        System.out.println(mainlist);

        ArrayList<Integer> heights = new ArrayList<>();
        heights.add(1);
        heights.add(8);
        heights.add(6);
        heights.add(2);
        heights.add(5);
        heights.add(4);
        heights.add(8);
        heights.add(3);
        heights.add(7);
        containerWithMostWater(heights); // brute force
        containerWithMostWater2(heights); // 2 pointer

        pairSum(heights, 8); // brute force
        pairSum2(list, 5); // 2 pointer

        ArrayList<Integer> SortedRotatedList = new ArrayList<>();
        SortedRotatedList.add(11);
        SortedRotatedList.add(15);
        SortedRotatedList.add(6);
        SortedRotatedList.add(8);
        SortedRotatedList.add(9);
        SortedRotatedList.add(10);

        pairSumOfSortedAndRotated(SortedRotatedList, 21);

        System.out.println("*** LinkedList ***");

        Linkedlist Ll = new Linkedlist();
        Ll.addFirst(2);
        Ll.addFirst(1);
        Ll.addLast(3);
        Ll.addLast(4);

        Ll.addAtMid(2, 5);

        Ll.printLinkedList();
        System.out.println("LinkedList size = " + Linkedlist.size);

        System.out.println("Iterative search = " + Ll.itrativeSearch(5));
        System.out.println("Recursive search = " + Ll.recursiveSearch(5));

        Ll.reverse();
        Ll.printLinkedList();

        Ll.delNthFromEnd(2);
        Ll.printLinkedList();

        System.out.println(Ll.isPalindrome());

        // Cycle detection
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;

        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());

        // Java Collection framework (JCF)
        LinkedList<Integer> LL = new LinkedList<>();

        // Add
        LL.addFirst(0);
        LL.addLast(1);
        LL.addLast(2);
        LL.addLast(3);
        LL.addLast(4);

        // Remove
        // LL.removeFirst();
        // LL.removeLast();

        // // Print
        // System.out.println(LL);

        Practice Ll1 = new Practice();
        Practice.addFirst(1);
        Practice.addFirst(2);
        Practice.addFirst(3);
        Practice.addFirst(4);

        Practice.printLinkedList();
        Practice.head = Practice.mergeSortLL(Practice.head);
        Practice.printLinkedList();

        System.out.println(Ll1);

        Linkedlist Ll2 = new Linkedlist();
        Ll2.addFirst(2);
        Ll2.addFirst(1);
        Ll2.addLast(3);
        Ll2.addLast(4);
        Ll2.addLast(5);
        Ll2.addLast(6);

        Ll2.printLinkedList();
        Ll2.zigZag();
        Ll2.printLinkedList();

        System.out.println("*** Stack ***");

        // STACK Using arrayList
        // STACK s = new STACK();
        STACK.push(1);
        STACK.push(2);
        STACK.push(3);

        // while (!STACK.isEmpty()) {
        // System.out.println(STACK.peek());
        // STACK.pop();
        // }

        System.out.println();

        // STACK Using linkedList
        STACK2.push(1);
        STACK2.push(2);
        STACK2.push(3);

        // while (!STACK2.isEmpty()) {
        // System.out.println(STACK2.peek());
        // STACK2.pop();
        // }

        System.out.println();

        // Stack using java collection framework (JCF)
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        // while (!s.isEmpty()) {
        // System.out.println(s.peek());
        // s.pop();
        // }

        // pushAtBottom(s, 4);

        while (!s.isEmpty()) {
            // Peek
            System.out.println(s.peek());
            // Pop
            s.pop();
        }
        System.out.println(reverseStringUsingStack("abc"));

        int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[stocks.length];
        stockSpan(stocks, span);
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }

        System.out.println();

        int nextRightArr[] = { 6, 8, 0, 1, 3 };
        nextGreaterRight(nextRightArr);

        nextGreaterRight2(nextRightArr);

        nextGreaterLeft(nextRightArr);

        String STR = "({}[])";
        System.out.println(isValidParenteses(STR));

        String STR1 = "(((a+b)+(c+d)))";
        System.out.println(isDuplicateParentheses(STR1));
        String STR2 = "((a+b)+(c+d))";
        System.out.println(isDuplicateParentheses(STR2));

        int AreaArray[] = { 2, 1, 5, 6, 2, 3 };
        maxAreaOfHistogram(AreaArray);

        System.out.println("*** Queue***");

        // Queue1 q1 = new Queue1(3);
        // q1.add(1);
        // q1.add(2);
        // q1.add(3);

        // while (!q1.isEmpty()) {
        // System.out.println(q1.peek());
        // q1.remove();
        // }

        // QueueUsingLinkedList q1 = new QueueUsingLinkedList();
        // q1.add(1);
        // q1.add(2);
        // q1.add(3);

        // while (!q1.isEmpty()) {
        // System.out.println(q1.peek());
        // q1.remove();
        // }

        // Queue using Java collection framework
        Queue<Integer> q = new LinkedList<>();
        // As queue is interface hence we cant create object
        // but we can create object by implemented class like
        // LinkedList() and ArrayDeque()
        // q.add(1);
        // q.add(2);
        // q.add(3);

        // while (!q.isEmpty()) {
        // System.out.println(q.peek());
        // q.remove();
        // }

        // QueueUsing2Stack.add(1);
        // QueueUsing2Stack.add(2);
        // QueueUsing2Stack.add(3);
        // while (!QueueUsing2Stack.isEmpty()) {
        // System.out.println(QueueUsing2Stack.peek());
        // QueueUsing2Stack.remove();
        // }

        // Stack s1 = new Stack();
        // s1.push(1);
        // s1.push(2);
        // s1.push(3);
        // while (!s1.isEmpty()) {
        // System.out.println(s1.peek());
        // s1.pop();
        // }

        firstNonRepeatingNo("aabccxb");
        System.out.println();

        // Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        // // Function called
        // interleaveTwoHalfOFQueue(q);

        // // print Queue
        // while (!q.isEmpty()) {
        // System.out.print(q.peek() + " ");
        // q.remove();
        // }

        // Function called
        queueReversal(q);

        // print Queue
        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
        System.out.println();

        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
        System.out.println(deque);
        deque.removeFirst();
        deque.removeLast();
        System.out.println(deque);
        System.out.println("Get first = " + deque.getFirst());
        System.out.println("Get last = " + deque.getLast());

        System.out.println("*** Greedy Algorithm ***");

        // sorted end time
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };
        activitySelection(start, end);

        System.out.println();

        // unsorted end time
        int start2[] = { 0, 1, 3, 5, 5, 8 };
        int end2[] = { 6, 2, 4, 7, 9, 9 };
        activitySelection2(start2, end2);

        System.out.println();

        int value[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int w = 50;
        fractionalKnapsack(value, weight, w);

        int A[] = { 4, 1, 8, 7 };
        int B[] = { 2, 3, 6, 5 };
        minAbsoluteDiff(A, B);

        int pair[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        maxChainPair(pair);

        Integer coins[] = { 1, 5, 10, 20, 50, 100, 500, 2000 };
        indianCoin(coins, 121);
        System.out.println();

        int jobInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
        jobSequencing(jobInfo);

        // Integer horizontalCost[] = { 2, 1, 3, 1, 4 }; // m-1
        // Integer verticalCost[] = { 4, 1, 2 }; // n-1
        chocolaProblem();

        System.out.println("*** Binary trees***");
        // int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        // BinaryTree tree = new BinaryTree();
        // Node1 root = BinaryTree.buildTree(nodes);
        // System.out.println("Root = " + root.data);
        // System.out.println(root.left.data);
        // System.out.println(root.right.data);

        // System.out.print("Preorder = ");
        // BinaryTree.preOrder(root);
        // System.out.println();

        // System.out.print("Inorder = ");
        // BinaryTree.inOrder(root);
        // System.out.println();

        // System.out.print("Postorder = ");
        // BinaryTree.postOrder(root);
        // System.out.println();

        // System.out.println("Levelorder = ");
        // BinaryTree.levelOrder(root);
        // System.out.println();

        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         * 
         */
        Node1 root = new Node1(1);
        root.left = new Node1(2);
        root.right = new Node1(3);
        root.left.left = new Node1(4);
        root.left.right = new Node1(5);
        root.right.left = new Node1(6);
        root.right.right = new Node1(7);

        System.out.println("Height of tree = " + BinaryTree.heightOfBT(root));
        System.out.println("Count of nodes = " + BinaryTree.countNode(root));
        System.out.println("sum of nodes = " + BinaryTree.sumOfNode(root));
        System.out.println("Diameter of nodes = " + BinaryTree.diameter(root));
        System.out.println("Diameter of nodes = " + BinaryTree.diameter2(root).diameter);

        // SubTree
        /*
         * 2
         * / \
         * 4 5
         */
        Node1 subRoot = new Node1(2);
        subRoot.left = new Node1(4);
        subRoot.right = new Node1(5);

        System.out.println(BinaryTree.isSubtree(root, subRoot));

        System.out.println("Top view = ");
        BinaryTree.topView(root);

        System.out.println();

        System.out.println("Kth Level Node = ");
        // BinaryTree.kthLevel(root, 3);
        BinaryTree.kthLevel2(root, 1, 3);

        System.out.println();

        int n1 = 4, n2 = 6;
        System.out.println("Lowest common Ancestor = " + BinaryTree.lca(root, n1, n2).data);
        System.out.println("Lowest common Ancestor = " + BinaryTree.lca2(root, n1, n2).data);

        System.out.println("Min diatance between nodes = " + BinaryTree.minDistance(root, n1, n2));

        BinaryTree.kthAncestor(root, n1, 2);

        BinaryTree.preOrder(root);
        System.out.println();
        BinaryTree.transform(root);
        BinaryTree.preOrder(root);
        System.out.println();

        System.out.println("*** Binary Search trees***");

        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node2 rootNode = null;
        for (int i = 0; i < values.length; i++) {
            rootNode = insert(rootNode, values[i]);
        }
        // this print in sorted order
        inorder(rootNode);
        System.out.println();

        if (searchInBST(rootNode, 4)) {
            System.out.println("key found");
        } else {
            System.out.println("key not found");
        }

        System.out.println("delete node");
        // deleteNode(rootNode, 1);
        inorder(rootNode);

        System.out.println();

        int k1 = 3;
        int k2 = 5;
        System.out.println("Node in range " + k1 + " to " + k2);
        printInRangeNode(rootNode, k1, k2);
        System.out.println();

        System.out.println("Root to leaf path = ");
        rootToLeafPath(rootNode, new ArrayList<>());

        System.out.println(isValidBST(rootNode, null, null));

        preorder(rootNode);
        System.out.println();
        mirrorBST(rootNode);
        preorder(rootNode);
        System.out.println();

        int NodeArray[] = { 3, 5, 6, 8, 10, 11, 12 };
        Node2 newBalancedRoot = createBalancedBST(NodeArray, 0, NodeArray.length - 1);
        preorder(newBalancedRoot);
        System.out.println();

        // BST
        /*
         * 8
         * / \
         * 6 10
         * / \
         * 5 11
         * / \
         * 3 12
         */

        Node2 BSTroot = new Node2(8);
        BSTroot.left = new Node2(6);
        BSTroot.left.left = new Node2(5);
        BSTroot.left.left.left = new Node2(3);
        BSTroot.right = new Node2(10);
        BSTroot.right.right = new Node2(11);
        BSTroot.right.right.right = new Node2(12);
        System.out.println("Sequence before balanceBST");
        preorder(BSTroot);
        System.out.println();

        // Balanced BST
        /*
         * 8
         * / \
         * 5 11
         * / \ / \
         * 3 6 10 12
         */

        BSTroot = BSTtoBalancedBST(BSTroot);
        System.out.println("Sequence after balanceBST");
        preorder(BSTroot);

        /*
         * 50
         * / \
         * 30 60
         * / \ / \
         * 5 20 45 70
         * / \
         * 65 80
         */
        Node2 newroot = new Node2(50);
        newroot.left = new Node2(30);
        newroot.left.left = new Node2(5);
        newroot.left.right = new Node2(20);
        newroot.right = new Node2(60);
        newroot.right.left = new Node2(45);
        newroot.right.right = new Node2(70);
        newroot.right.right.left = new Node2(65);
        newroot.right.right.right = new Node2(80);

        /*
         * 60
         * / \
         * 45 70
         * / \
         * 65 80
         * Expected BST : size = 5
         */

        Info2 info = largestBST(newroot);
        System.out.println(info);
        System.out.println("Largest BST size = " + maxBST);

        // BST 1
        Node2 root1 = new Node2(2);
        root1.left = new Node2(1);
        root1.right = new Node2(4);

        // BST 2
        Node2 root2 = new Node2(9);
        root2.left = new Node2(3);
        root2.right = new Node2(12);

        // T.c = O(n+m)
        Node2 mergeroot = merge2BST(root1, root2);
        preorder(mergeroot);
    }
}