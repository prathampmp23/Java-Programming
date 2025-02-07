package Z_Practice;

import java.util.ArrayList;
import java.util.Collections;

public class Arraylist {

    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    // Container with most water (Brute force approach) - O(n^2)
    public static void storedWater(ArrayList<Integer> height) {
        int maxWater = 0;
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int wt = j - i;
                int currWater = ht * wt;
                maxWater = Math.max(maxWater, currWater);
            }
        }
        System.out.println("Max water stored in container = " + maxWater);
    }

    // Container with most water (2 Pointer Approach) - O(n)
    public static void storedWater2(ArrayList<Integer> height) {
        int maxWater = 0;
        int Lp = 0;
        int Rp = height.size() - 1;
        while (Lp < Rp) {
            // calculate water area
            int ht = Math.min(height.get(Lp), height.get(Rp));
            int wt = Rp - Lp;
            int currWater = ht * wt;
            maxWater = Math.max(maxWater, currWater);
            // update pointer
            if (Lp < Rp) {
                Lp++;
            } else {
                Rp--;
            }
        }
        System.out.println("Max water stored in container = " + maxWater);
    }

    // PairSum 1 (Brute force) - O(n^2)
    public static boolean pairSum1(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // PairSum 1 (2 Pointer Approach) - O(n)
    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int Lp = 0;
        int Rp = list.size() - 1;
        while (Lp != Rp) {
            // case 1
            if (list.get(Lp) + list.get(Rp) == target) {
                return true;
            }
            // update pointer
            // case 2
            if (list.get(Lp) + list.get(Rp) < target) {
                Lp++;
            }
            // case 3
            else {
                Rp--;
            }
        }
        return false;
    }

    // PairSum 2 (2 pointer approach) - O(n)
    public static boolean pairSum(ArrayList<Integer> list, int target) {
        int bp = -1;
        int n = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(i + 1)) { // breaking point
                bp = i;
                break;
            }
        }
        int Lp = bp + 1; // smallest
        int Rp = bp; // largest
        while (Lp != Rp) {
            // case 1
            if (list.get(Lp) + list.get(Rp) == target) {
                return true;
            }
            // case 2
            if (list.get(Lp) + list.get(Rp) < target) {
                Lp = (Lp + 1) % n;
            }
            // case 3
            else {
                Rp = (n + Rp - 1) % n;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // ** Integer Data type
        ArrayList<Integer> list = new ArrayList<>();

        // To Add operation
        list.add(1); // T.c = O(1)
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1, 8); // T.c = O(n)

        // Print Arraylist
        System.out.println(list);

        // To Get operation T.c = O(1)
        int element = list.get(2);
        System.out.println(element);

        // Delete (remove) operation T.c = O(n)
        list.remove(2);
        System.out.println(list);

        // Set operation T.c = O(n)
        list.set(2, 10);
        System.out.println(list);

        // Contains operation T.c = O(n)
        System.out.println(list.contains(1));
        System.out.println(list.contains(5));

        // size() method or function
        System.out.println("Size = " + list.size());

        // print arraylist using loop - O(n)
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // print reverse of arraylist using loop - O(n)
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // Find Maximum - O(n)
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        System.out.println("Maximum = " + max);

        // swap of 2 numbers
        int idx1 = 1, idx2 = 3;
        System.out.println(list);
        swap(list, idx1, idx2);
        System.out.println(list);

        // Sorting in ArrayList
        Collections.sort(list);
        System.out.println(list);

        // sorted in reverse order
        // it's logic is defined in comparator function
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        // Multi Dimensional ArrayList
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        // loop for storing no in the form of tables
        for (int i = 1; i <= 5; i++) {
            list1.add(i * 1); // 1 2 3 4 5
            list2.add(i * 2); // 2 4 6 8 10
            list3.add(i * 3); // 3 6 9 12 15
        }

        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        System.out.println(mainList);
        for (int i = 0; i < mainList.size(); i++) {
            ArrayList<Integer> currList = mainList.get(i);
            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }
            System.out.println();
        }

        // Container with most water
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        // Brute Force
        storedWater(height);
        // 2 Pointer approach
        storedWater2(height);

        // PairSum 1
        ArrayList<Integer> List = new ArrayList<>();
        List.add(1);
        List.add(2);
        List.add(3);
        List.add(4);
        List.add(5);
        // T.c = O(n^2)
        System.out.println(pairSum1(List, 5));
        // T.c = O(n)
        System.out.println(pairSum2(List, 5));

        // PairSum 2
        ArrayList<Integer> List1 = new ArrayList<>();
        List1.add(11);
        List1.add(15);
        List1.add(6);
        List1.add(8);
        List1.add(9);
        List1.add(10);

        // T.c = O(n)
        System.out.println(pairSum(List1, 16));
    }
}
