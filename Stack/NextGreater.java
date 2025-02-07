package Stack;

import java.util.Stack;

public class NextGreater {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // next greater Right
    public static void nextGreaterRight(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int nextRightGreater[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            // While loop
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            // if-else
            if (s.isEmpty()) {
                nextRightGreater[i] = -1;
            } else {
                nextRightGreater[i] = arr[s.peek()];
            }
            // push idx in stack
            s.push(i);
        }
        printArray(nextRightGreater);
    }

    // next greater Left
    public static void nextGreaterLeft(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int nextRightGreater[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            // While loop
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            // if-else
            if (s.isEmpty()) {
                nextRightGreater[i] = -1;
            } else {
                nextRightGreater[i] = arr[s.peek()];
            }
            // push in stack
            s.push(i);
        }
        printArray(nextRightGreater);
    }

    // next Smaller Right
    public static void nextSmallerRight(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int nextRightSmaller[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            // While loop
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            // if-else
            if (s.isEmpty()) {
                nextRightSmaller[i] = -1;
            } else {
                nextRightSmaller[i] = arr[s.peek()];
            }
            // push in stack
            s.push(i);
        }
        printArray(nextRightSmaller);
    }

    // next Smaller Left
    public static void nextSmallerLeft(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int nextRightSmaller[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            // While loop
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            // if-else
            if (s.isEmpty()) {
                nextRightSmaller[i] = -1;
            } else {
                nextRightSmaller[i] = arr[s.peek()];
            }
            // push in stack
            s.push(i);
        }
        printArray(nextRightSmaller);
    }

    public static void main(String[] args) {

        // ** This Next Greater problem comes in 4 forms **

        int arr[] = { 6, 8, 0, 1, 3 };
        // 1. Next Greater Right = for (int i = arr.length - 1; i >= 0; i--) and
        // arr[s.peek()] <= arr[i]
        nextGreaterRight(arr);
        // 2. Next Greater Left = for (int i = 0; i < arr.length; i++) and
        // arr[s.peek()] <= arr[i]
        nextGreaterLeft(arr);
        // 3. Next Smaller Right = for (int i = arr.length - 1; i >= 0; i--) and
        // arr[s.peek()] >= arr[i]
        nextSmallerRight(arr);
        // 4. Next Smaller Left = for (int i = 0; i < arr.length; i++) and
        // arr[s.peek()] >= arr[i]
        nextSmallerLeft(arr);

    }
}
