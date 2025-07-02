package ArrayList;

import java.util.ArrayList;

/*
 * In this we use Modular Arithmatic that is for Sorted & Rotated array
 *   Its increment condition is change from lp++ or rp-- to
 *  leftPointer (lp) = (lp+1)%n
 *  rightpointer (rp) = (n+rp-1)%n
 */
public class PairSum2 {
    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int pivot = -1;
        int n = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(i + 1)) {
                pivot = i;
                break;
            }
        }
        int lp = pivot + 1; // Smallest
        int rp = pivot;

        while (lp != rp) {
            // case1
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            }
            // case2
            if (list.get(lp) + list.get(rp) < target) {
                lp = (lp + 1) % n;
            } else {
                // case3
                rp = (n + rp - 1) % n;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16;
        System.out.println(pairSum2(list, target));

    }
}