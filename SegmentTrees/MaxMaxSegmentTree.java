package SegmentTrees;

public class MaxMaxSegmentTree {

    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];
    }

    // ****** Max Segment tree *****
    // Create T.c = O(n)
    public static void buildSt(int arr[], int i, int si, int sj) {
        if (si == sj) {
            tree[i] = arr[si]; // for leaf node
            return;
        }
        int mid = (si + sj) / 2; // for larger array si + (sj-si)/2 optimized
        buildSt(arr, 2 * i + 1, si, mid);
        buildSt(arr, 2 * i + 2, mid + 1, sj);

        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    // Query - O(logn)
    public static int getMaxUtil(int i, int si, int sj, int qi, int qj) {
        if (qj < si || qi > sj) { // non overlapping
            return Integer.MIN_VALUE; // -infinity
        } else if (si >= qi && sj <= qj) { // complete overlapping
            return tree[i];
        } else { // partial overlapped
            int mid = (si + sj) / 2;
            int left = getMaxUtil(2 * i + 1, si, mid, qi, qj);
            int right = getMaxUtil(2 * i + 2, mid + 1, sj, qi, qj);
            return Math.max(left, right);
        }
    }

    public static int getMax(int arr[], int qi, int qj) {
        int n = arr.length;
        return getMaxUtil(0, 0, n - 1, qi, qj);
    }

    // Update - O(logn)
    public static void updateUtil(int i, int si, int sj, int idx, int newVal) {
        if (idx < si || idx > sj) { // non overlapping
            return;
        }
        tree[i] = Math.max(tree[i], newVal); // overlapping
        if (si != sj) { // non leaf
            int mid = (si + sj) / 2;
            updateUtil(2 * i + 1, si, mid, idx, newVal); // left
            updateUtil(2 * i + 2, mid + 1, sj, idx, newVal); // right
        }
    }

    public static void update(int arr[], int idx, int newVal) {
        int n = arr.length;
        arr[idx] = newVal; // arr updation
        updateUtil(0, 0, n - 1, idx, newVal); // segment tree updation
    }

    // ****** Min Segment tree *****
    static int tree2[];

    public static void init2(int n) {
        tree2 = new int[4 * n];
    }

    // Create T.c = O(n)
    public static void buildSt2(int arr[], int i, int si, int sj) {
        if (si == sj) {
            tree2[i] = arr[si]; // for leaf node
            return;
        }
        int mid = (si + sj) / 2; // for larger array si + (sj-si)/2 optimized
        buildSt2(arr, 2 * i + 1, si, mid);
        buildSt2(arr, 2 * i + 2, mid + 1, sj);

        tree2[i] = Math.min(tree2[2 * i + 1], tree2[2 * i + 2]);
    }

    // Query - O(logn)
    public static int getMinUtil(int i, int si, int sj, int qi, int qj) {
        if (qj < si || qi > sj) { // non overlapping
            return Integer.MAX_VALUE; // +infinity
        } else if (si >= qi && sj <= qj) { // complete overlapping
            return tree2[i];
        } else { // partial overlapped
            int mid = (si + sj) / 2;
            int left = getMinUtil(2 * i + 1, si, mid, qi, qj);
            int right = getMinUtil(2 * i + 2, mid + 1, sj, qi, qj);
            return Math.min(left, right);
        }
    }

    public static int getMin(int arr[], int qi, int qj) {
        int n = arr.length;
        return getMinUtil(0, 0, n - 1, qi, qj);
    }

    // Update - O(logn)
    public static void updateUtil2(int i, int si, int sj, int idx, int newVal) {
        if (idx < si || idx > sj) { // non overlapping
            return;
        }
        tree2[i] = Math.min(tree2[i], newVal); // overlapping
        if (si != sj) { // non leaf
            int mid = (si + sj) / 2;
            updateUtil2(2 * i + 1, si, mid, idx, newVal); // left
            updateUtil2(2 * i + 2, mid + 1, sj, idx, newVal); // right
        }
    }

    public static void update2(int arr[], int idx, int newVal) {
        int n = arr.length;
        arr[idx] = newVal; // arr updation
        updateUtil2(0, 0, n - 1, idx, newVal); // segment tree2 updation
    }

    public static void printTree(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // ****** Max Segment tree *****
        int arr[] = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };
        int n = arr.length;
        init(n);
        buildSt(arr, 0, 0, n - 1);
        printTree(tree);

        System.out.println("Max Segment tree = " + getMax(arr, 2, 5));

        update(arr, 2, 20);
        printTree(tree);
        System.out.println("Max Segment tree after update = " + getMax(arr, 2, 5));

        System.out.println();

        // ****** Min Segment tree *****
        int arr2[] = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };
        int n2 = arr2.length;
        init2(n2);
        buildSt2(arr2, 0, 0, n2 - 1);
        printTree(tree2);

        System.out.println("Min Segment tree = " + getMin(arr2, 2, 5));

        update2(arr2, 2, 20);
        printTree(tree2);
        System.out.println("Min Segment tree after update = " + getMin(arr2, 2, 5));

    }
}
