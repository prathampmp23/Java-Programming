package SegmentTrees;

public class SegmentTree {

    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];
    }

    // Create T.c = O(n)
    public static int buildSt(int arr[], int i, int st, int ed) {
        if (st == ed) {
            tree[i] = arr[st]; // for leaf node
            return arr[st];
        }
        int mid = (st + ed) / 2;
        buildSt(arr, 2 * i + 1, st, mid);
        buildSt(arr, 2 * i + 2, mid + 1, ed);

        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
        return tree[i];
    }


    // Query - O(logn)
    public static int getSumUtil(int i, int si, int sj, int qi, int qj) {
        if (qj < si || qi > sj) { // non overlapping
            return 0;
        } else if (si >= qi && sj <= qj) { // complete overlapping
            return tree[i];
        } else { // partial overlapped
            int mid = (si + sj) / 2;
            int left = getSumUtil(2 * i + 1, si, mid, qi, qj);
            int right = getSumUtil(2 * i + 2, mid + 1, sj, qi, qj);
            return left + right;
        }
    }
    public static int getSum(int arr[], int qi, int qj) {
        int n = arr.length;
        return getSumUtil(0, 0, n - 1, qi, qj);
    }

    
    // Update - O(logn)
    public static void updateUtil(int i, int si, int sj, int idx, int diff) {
        if (idx < si || idx > sj) { // non overlapping
            return;
        }
        tree[i] += diff; // overlapping
        if (si != sj) { // non leaf
            int mid = (si + sj) / 2;
            updateUtil(2 * i + 1, si, mid, idx, diff); // left
            updateUtil(2 * i + 2, mid + 1, sj, idx, diff); // right
        }
    }
    public static void update(int arr[], int idx, int newVal) {
        int n = arr.length;
        int diff = newVal - arr[idx];
        arr[idx] = newVal; // arr updation
        updateUtil(0, 0, n - 1, idx, diff); // segment tree updation
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;
        init(n);
        buildSt(arr, 0, 0, n - 1);
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }

        System.out.println();

        System.out.println(getSum(arr, 2, 5));
        
        update(arr, 2, 2);
        System.out.println(getSum(arr, 2, 5));
         for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }

    }
}